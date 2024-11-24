package com.example.javafxproject;

import com.example.controller.ClientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ClientPanelController {

    @FXML
    private AnchorPane anch_Clientpage;

    @FXML
    private Button btn_Back;

    @FXML
    private Button btn_ChargeAcc;

    @FXML
    private Button btn_buyHistory;

    @FXML
    private Button btn_personalInformation;

    @FXML
    private Button btn_shop_purchase;

    @FXML
    private ImageView img_ClientPage;

    @FXML
    private TitledPane titPane_CostumerFacilities;

    @FXML
    private VBox vBox_Facilities;

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 765, 555);
        Main.stage.setTitle("Login page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void chargeAccount(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ChargeAccountPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 765, 555);
        Main.stage.setTitle("Charge Account Page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void seeBuyHistory(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SeeBuyHistoryPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 765, 555);
        Main.stage.setTitle("Buy History");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void shopStuff_Purchase(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("showAllStuffs.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 891, 700);
        Main.stage.setTitle("Stuffs page");
        Main.stage.setScene(scene);
        Main.stage.show();

    }

    @FXML
    void showPersonalInformation(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PersonalInformationPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 765, 555);
        Main.stage.setTitle("Personal Information");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

}
