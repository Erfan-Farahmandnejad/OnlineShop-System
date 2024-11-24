package com.example.javafxproject;

import com.example.Exceptions.InvalidEmail;
import com.example.Exceptions.InvalidPassword;
import com.example.Exceptions.InvalidPhoneNumber;
import com.example.controller.ClientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class SignUpPageController {

    @FXML
    private CheckBox Cbox_cooki;

    @FXML
    private AnchorPane anch_SignUP;

    @FXML
    private Button btn_Submit;

    @FXML
    private Button btn_back;

    @FXML
    private ImageView img_phone;

    @FXML
    private ImageView img_signUp;

    @FXML
    private TextField txtFd_email;

    @FXML
    private TextField txtFd_name;

    @FXML
    private TextField txtFd_password;

    @FXML
    private TextField txtFd_phone;

    @FXML
    private Text txt_SignUp;

    @FXML
    void SignUpOperartion(ActionEvent event) {
        btn_Submit.setDisable(true);
        String userName=txtFd_name.getText();
        String phoneNumber=txtFd_phone.getText();
        String email=txtFd_email.getText();
        String password=txtFd_password.getText();
        ClientController controller=new ClientController();

        String[] result=new String[1];
        result[0]="empty";
        try {
            result[0]= controller.signUp(userName,email,phoneNumber,password);
        } catch (InvalidEmail | InvalidPhoneNumber | InvalidPassword e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Information");
            alert.setContentText(e.getMessage());
            alert.show();
        }
        if (result[0].contains("SignUpRequest"))
        {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("SignUp Request");
            alert.setContentText("Your SignUp Request successfully sent to administrator when administrator accepts You can login");
            alert.show();
        }
        else
        {
            if (result[0].contains("password") || result[0].contains("has been taken")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("repetitive Information");
                alert.setContentText(result[0]);
                alert.show();
            }
        }

    }

    @FXML
    void backFunction(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("firstPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        Main.stage.setTitle("Main page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void youCanSubmit(ActionEvent event) {

        btn_Submit.setDisable(!Cbox_cooki.isSelected());
    }

}
