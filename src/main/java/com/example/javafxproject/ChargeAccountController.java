package com.example.javafxproject;

import com.example.controller.ClientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.example.view.AdminPanel;

import java.io.IOException;

public class ChargeAccountController {

    @FXML
    private AnchorPane anch_Charge;

    @FXML
    private Button btn_Back;

    @FXML
    private Button btn_Submit;

    @FXML
    private HBox hbox_Charge;

    @FXML
    private ImageView img_Charge;

    @FXML
    private ImageView img_Logo;

    @FXML
    private Label lbl_Amout;

    @FXML
    private Label lbl_CardNumber;

    @FXML
    private Label lbl_Cvv2;

    @FXML
    private Label lbl_Pass;

    @FXML
    private TextField txt_Amout;

    @FXML
    private TextField txt_CardNumber;

    @FXML
    private TextField txt_Cvv2;

    @FXML
    private TextField txt_Pass;

    @FXML
    private VBox vBox_chargeLbl;

    @FXML
    private VBox vBox_chargeTxt;

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ClientPanelPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 765, 555);
        Main.stage.setTitle("Login page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void chargeAccount(ActionEvent event) {
        ClientController clientController=new ClientController();
        String result=clientController.accountChargeRequest(LoginPageController.clientName,txt_CardNumber.getText(),txt_Cvv2.getText(),txt_Pass.getText(), Double.parseDouble(txt_Amout.getText()));
        if (result.contains("accountChargeRequest:"))
        {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("AccountCharge");
            alert.setContentText(result);
            alert.show();
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("AccountCharge");
            alert.setContentText(result);
            alert.show();
        }
    }

}
