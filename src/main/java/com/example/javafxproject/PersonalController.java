package com.example.javafxproject;

import com.example.Exceptions.InvalidEmail;
import com.example.Exceptions.InvalidPassword;
import com.example.Exceptions.InvalidPhoneNumber;
import com.example.controller.AdminController;
import com.example.controller.ClientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import com.example.model.Roles.ClientModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonalController implements Initializable {

    @FXML
    private AnchorPane anch_Personal;

    @FXML
    private Button btn_Back;

    @FXML
    private Button btn_EditEmail;

    @FXML
    private Button btn_EditPass;

    @FXML
    private Button btn_EditPhone;

    @FXML
    private ImageView img_Personal;

    @FXML
    private Label lbl_AccountCharge;

    @FXML
    private Label lbl_AccountCharge1;

    @FXML
    private Label lbl_email;

    @FXML
    private Label lbl_email1;

    @FXML
    private Label lbl_password;

    @FXML
    private Label lbl_password1;

    @FXML
    private Label lbl_phoneNumber;

    @FXML
    private Label lbl_phoneNumber1;

    @FXML
    private Label lbl_useName;

    @FXML
    private Label lbl_useName1;

    @FXML
    private TextField txtFd_Email;

    @FXML
    private TextField txtFd_PhoneNumber;

    @FXML
    private TextField txtFd_password;

    @FXML
    private VBox vBox_Personal;

    @FXML
    private VBox vBox_PersonalInformation;

    @FXML
    private VBox vBox_PersonalInformation1;


    @FXML
    void back(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ClientPanelPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 770, 560);
        Main.stage.setTitle("Login page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void editPassword(ActionEvent event) {
        ClientController clientController=new ClientController();
       int [] result=new int[1];
        try {
            result[0] = clientController.editPassword(LoginPageController.clientName,txtFd_password.getText());
        } catch (InvalidPassword e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Password");
            alert.setContentText(e.getMessage());
        }
        if (result[0]==1)
        {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Edit Password");
            alert.setContentText("Password changed successfully");
            alert.show();
        }
        else
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Password");
            alert.setContentText("Password changed unsuccessfully!!");
            alert.show();
        }
    }

    @FXML
    void editPhoneNumber(ActionEvent event) {
        ClientController clientController=new ClientController();
        int [] result=new int[1];
        try {
            result [0] = clientController.editPhoneNumber(LoginPageController.clientName,txtFd_PhoneNumber.getText());
        } catch (InvalidPhoneNumber e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit PhoneNumber");
            alert.setContentText(e.getMessage());
        }
        if (result[0]==1)
        {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Edit PhoneNumber");
            alert.setContentText("PhoneNumber changed successfully");
            alert.show();
        }
        else
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit PhoneNumber");
            alert.setContentText("PhoneNumber changed unsuccessfully!!");
            alert.show();
        }
    }

    @FXML
    void editEmail(ActionEvent event) {
        ClientController clientController=new ClientController();
        int [] result=new int[1];
        try {
            result [0] = clientController.editEmail(LoginPageController.clientName,txtFd_Email.getText());
        } catch (InvalidEmail e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Email");
            alert.setContentText(e.getMessage());
        }
        if (result[0]==1)
        {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Edit Email");
            alert.setContentText("Email changed successfully");
            alert.show();
        }
        else
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit Email");
            alert.setContentText("Email changed unsuccessfully!!");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (ClientModel clientModel: AdminController.getClientList())
        {
            if (clientModel.getUserName().equals(LoginPageController.clientName))
            {
                lbl_useName.setText(clientModel.getUserName());
                lbl_email.setText(clientModel.getEmail());
                lbl_password.setText(clientModel.getPassword());
                lbl_phoneNumber.setText(clientModel.getPhoneNumber());
                lbl_AccountCharge.setText(String.valueOf(clientModel.getAccountCredit()));
            }
        }
    }
}
