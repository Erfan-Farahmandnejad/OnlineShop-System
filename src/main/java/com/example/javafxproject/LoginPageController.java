package com.example.javafxproject;

import com.example.controller.ClientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import com.example.view.AdminPanel;

import java.io.IOException;

public class LoginPageController {

    @FXML
    private AnchorPane anch_Login;

    @FXML
    private Button btn_Back;

    @FXML
    private RadioButton btn_LogAsUser;

    @FXML
    private Button btn_Submit;

    @FXML
    private RadioButton btn_logAsAdmin;

    @FXML
    private HBox hBox_Radio;

    @FXML
    private ImageView img_Avatar;

    @FXML
    private ImageView img_Login;

    @FXML
    private TextField txtFd_name;

    @FXML
    private TextField txtFd_password;

    @FXML
    private Text txt_LoginTitle;

    public static String clientName;

    @FXML
    void adminLogin(ActionEvent event) {
        if (btn_logAsAdmin.isSelected())
        {
            btn_LogAsUser.setSelected(false);
            btn_LogAsUser.setDisable(true);
            txtFd_password.setDisable(false);
            txtFd_name.setDisable(false);
        }
        else {
            btn_LogAsUser.setDisable(false);
            txtFd_password.setDisable(true);
            txtFd_name.setDisable(true);
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("firstPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        Main.stage.setTitle("Main page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void loginFunction(ActionEvent event) throws IOException {
        String username = txtFd_name.getText();
        String password = txtFd_password.getText();
        ClientController clientController=new ClientController();

        if (btn_LogAsUser.isSelected())
        {
            String result=clientController.signIn(username, password,1);

            if (result.contains("failed"))
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setContentText("Username and/or password are/is Incorrect");
                alert.show();
            }
            else
            {
                clientName=username;
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ClientPanelPage.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 765, 555);
                Main.stage.setTitle("Login page");
                Main.stage.setScene(scene);
                Main.stage.show();
            }
        }
        if (btn_logAsAdmin.isSelected())
        {
            String result=clientController.signIn(username, password,2);

            if (result.contains("failed"))
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setContentText("Username and/or password are/is Incorrect");
                alert.show();
            }
            else
            {
                AdminPanel adminPanel=new AdminPanel();
                adminPanel.adminOperations();
            }
        }
    }

    @FXML
    void userLogin(ActionEvent event) {
      if (btn_LogAsUser.isSelected())
      {
          btn_logAsAdmin.setSelected(false);
          btn_logAsAdmin.setDisable(true);
          txtFd_password.setDisable(false);
          txtFd_name.setDisable(false);
      }
      else {
          btn_logAsAdmin.setDisable(false);
          txtFd_password.setDisable(true);
          txtFd_name.setDisable(true);
      }

    }

}
