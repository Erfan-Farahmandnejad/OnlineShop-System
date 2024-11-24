package com.example.javafxproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstPageController {

    @FXML
    private AnchorPane anch_firstPage;

    @FXML
    private Button btn_Login;

    @FXML
    private Button btn_SeeStuffs;

    @FXML
    private Button btn_signUp;

    @FXML
    private ImageView img_Logo;

    @FXML
    private ImageView img_firstPage;

    @FXML
    private Label lbl_Welcome;

    @FXML
    void Login(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 730, 600);

        Main.stage.setTitle("Login Page");
        Main.stage.setScene(scene);
        Main.stage.show();

    }

    @FXML
    void SeeShopStuff(ActionEvent event) throws IOException {
     LoginPageController.clientName=null;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("showAllStuffs.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 891, 700);
        Main.stage.setTitle("Stuffs page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void SignUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SignUpPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 730, 600);
        Main.stage.setTitle("SignUp Page");
        Main.stage.setScene(scene);
        Main.stage.show();

    }

}
