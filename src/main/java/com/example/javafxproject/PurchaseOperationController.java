package com.example.javafxproject;

import com.example.controller.AdminController;
import com.example.controller.ClientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import com.example.model.Roles.ClientModel;
import com.example.model.Stuff.StuffKindModel;
import com.example.model.Stuff.StuffModel;
import com.example.view.AdminPanel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PurchaseOperationController implements Initializable {

    @FXML
    private AnchorPane anch_Purchase;

    @FXML
    private Button btn_Back;

    @FXML
    private Button btn_Discount;

    @FXML
    private Button btn_SubmitAdd;

    @FXML
    private Button btn_SubmitComment;

    @FXML
    private Button btn_SubmitRate;

    @FXML
    private Button btn_SubmitRemove;

    @FXML
    private Button btn_UltimatePurchase;

    @FXML
    private ImageView img_Logo;

    @FXML
    private ImageView img_Purchase;

    @FXML
    private TableColumn<StuffModel, Double> tC_AverageScore;

    @FXML
    private TableColumn<StuffModel, Integer> tC_StuffId;

    @FXML
    private TableColumn<StuffModel, Integer> tC_StuffInventory;

    @FXML
    private TableColumn<StuffModel, StuffKindModel> tC_StuffKInd;

    @FXML
    private TableColumn<StuffModel, String> tC_StuffName;

    @FXML
    private TableColumn<StuffModel, Double> tC_StuffPrice;

    @FXML
    private TableView<StuffModel> tV_AllStuffs;

    @FXML
    private TextField txt_RemoveStuff;

    @FXML
    private TextField txt_AddToCArt;

    @FXML
    private TextField txt_Comment;

    @FXML
    private TextField txt_Rate;

    @FXML
    private Slider sr_Score;

    @FXML
    void addToCart(ActionEvent event) {
        String input=txt_AddToCArt.getText();
        String [] arr=input.split("_");
        ClientController clientController=new ClientController();
        int resultNumber=clientController.addStuffToCart(LoginPageController.clientName,Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
        if (resultNumber==1)
        {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Add to Cart");
            alert.setContentText("Stuff added to cart successfully");
            alert.show();
        }
        if (resultNumber==0)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add to Cart");
            alert.setContentText(" Add Stuff to cart was unsuccessfully!!");
            alert.show();
        }
        tC_StuffName.setCellValueFactory(new PropertyValueFactory<>("stuffName"));
        tC_StuffId.setCellValueFactory(new PropertyValueFactory<>("stuffId"));
        tC_StuffPrice.setCellValueFactory(new PropertyValueFactory<>("stuffPrice"));
        tC_StuffKInd.setCellValueFactory(new PropertyValueFactory<>("stuffKindModel"));
        tC_StuffInventory.setCellValueFactory(new PropertyValueFactory<>("stuffInventory"));
        tC_AverageScore.setCellValueFactory(new PropertyValueFactory<>("averageScore"));
        tV_AllStuffs.getItems().clear();
        for (ClientModel clientModel: AdminController.getClientList())
        {
            if (clientModel.getUserName().equals(LoginPageController.clientName))
            {
                for (StuffModel stuffModel:clientModel.getCart())
                {
                    tV_AllStuffs.getItems().add(stuffModel);
                }
            }
        }
        tV_AllStuffs.refresh();

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("showAllStuffs.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 891, 700);
        Main.stage.setTitle("Stuffs page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void rateToCart(ActionEvent event) {

        ClientController clientController = new ClientController();
        int resultOfRate=clientController.rateToStuff((int) sr_Score.getValue(),LoginPageController.clientName,Integer.parseInt(txt_Rate.getText()));
        if (resultOfRate==1)
        {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Rating to a Stuff");
            alert.setContentText("Thanks for Rating,good luck!");
            alert.show();
        }
        if (resultOfRate==0)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Rating to a Stuff");
            alert.setContentText("You are not allowed to rate to this Stuff");
            alert.show();
        }

    }

    @FXML
    void removeStuffFromCart(ActionEvent event) {
        ClientController clientController=new ClientController();
        String input=txt_RemoveStuff.getText();

        int resultNumber=clientController.removeStuffFromCart(LoginPageController.clientName,Integer.parseInt(input));
        if (resultNumber==1)
        {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Remove from Cart");
            alert.setContentText("Stuff removed from cart successfully");
            alert.show();
        }
        if (resultNumber==0)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Remove from Cart");
            alert.setContentText("Removing Stuff from cart was unsuccessfully!!");
            alert.show();
        }

        tV_AllStuffs.getItems().clear();
        for (ClientModel clientModel: AdminController.getClientList())
        {
            if (clientModel.getUserName().equals(LoginPageController.clientName))
            {
                for (StuffModel stuffModel:clientModel.getCart())
                {
                    tV_AllStuffs.getItems().add(stuffModel);
                }
            }
        }
        tV_AllStuffs.refresh();

    }

    @FXML
    void seeYourDiscount(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SeeDiscounts.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 765, 555);
        Main.stage.setTitle("Your Discount page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void ultimatePurchase(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("UltimatePurchase.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 836, 651);
        Main.stage.setTitle("Ultimate Purchase page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void writeComment(ActionEvent event) {

        String input=txt_Comment.getText();
        String []array=input.split("_");
        ClientController clientController=new ClientController();
        String resultCheck =clientController.writeComment(LoginPageController.clientName,Integer.parseInt(array[0]),array[1]);
        if (resultCheck.equals("comment request failed"))
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Comment request");
            alert.setContentText(resultCheck);
            alert.show();
        }
        else
        {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Comment request");
            alert.setContentText(resultCheck);
            alert.show();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sr_Score.setSnapToTicks(true);
        sr_Score.setMajorTickUnit(1);
        sr_Score.setShowTickMarks(true);
        sr_Score.setShowTickLabels(true);
        tC_StuffName.setCellValueFactory(new PropertyValueFactory<>("stuffName"));
        tC_StuffId.setCellValueFactory(new PropertyValueFactory<>("stuffId"));
        tC_StuffPrice.setCellValueFactory(new PropertyValueFactory<>("stuffPrice"));
        tC_StuffKInd.setCellValueFactory(new PropertyValueFactory<>("stuffKindModel"));
        tC_StuffInventory.setCellValueFactory(new PropertyValueFactory<>("stuffInventory"));
        tC_AverageScore.setCellValueFactory(new PropertyValueFactory<>("averageScore"));
        tV_AllStuffs.getItems().clear();
        for (ClientModel clientModel: AdminController.getClientList())
        {
            if (clientModel.getUserName().equals(LoginPageController.clientName))
            {
                for (StuffModel stuffModel:clientModel.getCart())
                {
                    tV_AllStuffs.getItems().add(stuffModel);
                }
            }
        }
        tV_AllStuffs.refresh();
    }
}
