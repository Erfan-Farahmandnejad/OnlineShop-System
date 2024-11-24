package com.example.javafxproject;

import com.example.controller.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import com.example.model.Roles.AdminModel;
import com.example.model.Roles.ClientModel;
import com.example.model.UserModelFacilities.DiscountModel;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SeeDiscountsController implements Initializable {

    @FXML
    private AnchorPane anch_Discounts;

    @FXML
    private Button btn_Back;

    @FXML
    private ImageView img_Discount;

    @FXML
    private ImageView img_Logo;

    @FXML
    private TableColumn<DiscountModel, Integer> tC_Capacity;

    @FXML
    private TableColumn<DiscountModel, String> tC_Code;

    @FXML
    private TableColumn<DiscountModel, LocalDate> tC_Expiration;

    @FXML
    private TableColumn<DiscountModel, Double> tC_Percent;

    @FXML
    private TableView<DiscountModel> tV_Discounts;

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PurchaseOperation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 859, 751);
        Main.stage.setTitle("Purchase page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tC_Code.setCellValueFactory(new PropertyValueFactory<DiscountModel, String>("discountCode"));
        tC_Expiration.setCellValueFactory(new PropertyValueFactory<DiscountModel,LocalDate>("discountExpiration"));
        tC_Capacity.setCellValueFactory(new PropertyValueFactory<DiscountModel,Integer>("discountCapacity"));
        tC_Percent.setCellValueFactory(new PropertyValueFactory<DiscountModel,Double>("discountPercent"));
        tV_Discounts.getItems().clear();
        TableView.TableViewSelectionModel selectionModel=tV_Discounts.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);


        for (ClientModel clientModel: AdminController.getClientList())
        {
            if (clientModel.getUserName().equals(LoginPageController.clientName))
            {
                for (DiscountModel discountModel: clientModel.getClientDiscounts())
                {
                    tV_Discounts.getItems().add(discountModel);
                }
            }
        }
        tV_Discounts.refresh();
    }

    @FXML
    void copyDiscountCode(KeyEvent event) {
        TableView.TableViewSelectionModel selectionModel=tV_Discounts.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        for (Object row: selectionModel.getSelectedItems())
        {
            System.out.println(((DiscountModel)row).getDiscountCode());
        }
        selectionModel.clearSelection();
    }
}
