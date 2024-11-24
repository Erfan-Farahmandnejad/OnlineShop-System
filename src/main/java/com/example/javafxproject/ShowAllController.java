package com.example.javafxproject;

import com.example.controller.AdminController;
import com.example.model.Roles.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.example.model.Roles.AdminModel;
import com.example.model.Stuff.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShowAllController implements Initializable {

    @FXML
    private AnchorPane anch_Shop;

    @FXML
    private Button btn_Back;

    @FXML
    private Button btn_Disordered;

    @FXML
    private Button btn_Help;

    @FXML
    private Button btn_Purchase;

    @FXML
    private Button btn_SearchSubmit;

    @FXML
    private Button btn_Sort;

    @FXML
    private Button btn_StuffIdSubmit;

    @FXML
    private Button btn_filterSubmit;

    @FXML
    private ImageView img_AllStuff;

    @FXML
    private ImageView img_Logo;

    @FXML
    private Label lbl_Search;

    @FXML
    private TableColumn<StuffModel, String> tC_AverageScore;

    @FXML
    private TableColumn<StuffModel, String> tC_StuffId;

    @FXML
    private TableColumn<StuffModel, String> tC_StuffInventory;

    @FXML
    private TableColumn<StuffModel, String> tC_StuffKInd;

    @FXML
    private TableColumn<StuffModel, String> tC_StuffName;

    @FXML
    private TableColumn<StuffModel, String> tC_StuffPrice;

    @FXML
    private TableView<StuffModel> tV_AllStuffs;

    @FXML
    private TextField txt_Filter;

    @FXML
    private TextField txt_Search;

    @FXML
    private TextField txt_StuffPageId;
    @FXML
    private CheckBox cBox_LoggedIn;

    public static int iD;


    @FXML
    void filterHelp(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Filter Search explanation");
        alert.setContentText("filter options(please type):\n (by StuffKind) 1_model.Stuff.BicycleModel     2_model.Stuff.CarModel     3_DigitalStuffModel    4_model.Stuff.FlashMemoryModel    5_model.Stuff.FoodModel\n6_model.Stuff.NoteBookModel   " +
                "7_model.Stuff.PencilModel  8_model.Stuff.PersonalComputerModel     9_model.Stuff.SsdModel      10_StationeryModel\n11_StorageEquipmentModel    12_VehicleModel\n" +
                "(by stuffProperty) 1_StuffPrice(Enter min and max seperated by space after StuffPrice)    2_Is Stuff available    3_averageScore(Enter min and max seperated by space between 1 and 5)" +
                "\n4_CarCompanyName     5_StorageEquipment capacity     6_Pc cpu model      7_pc ram capacity   8_penColor ");
        alert.initModality(Modality.WINDOW_MODAL);
        alert.show();
    }
    //----------------------------------------------------------------
    @FXML
    void filterStuffs(ActionEvent event) {

       String orderString=txt_Filter.getText();
       String [] array= orderString.split(" ");
        tV_AllStuffs.getItems().clear();
        if (array[0].equals("model.Stuff.BicycleModel") || array[0].equals("model.Stuff.CarModel") || array[0].equals("model.Stuff.FlashMemoryModel") ||
                array[0].equals("model.Stuff.FoodModel") || array[0].equals("model.Stuff.NoteBookModel") || array[0].equals("model.Stuff.PencilModel") || array[0].equals("model.Stuff.PersonalComputerModel") ||
                array[0].equals("model.Stuff.SsdModel")) {

            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (stuffModel.getClass().getName().equals(orderString)) {
                    tV_AllStuffs.getItems().add(stuffModel);
                }
                tV_AllStuffs.refresh();
            }
        }
        if (array[0].equals("DigitalStuffModel")) {
            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (stuffModel instanceof DigitalStuffModel) {
                    tV_AllStuffs.getItems().add(stuffModel);
                }
                tV_AllStuffs.refresh();
            }
        }
        if (array[0].equals("StationeryModel")) {
            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (stuffModel instanceof StationeryModel) {
                    tV_AllStuffs.getItems().add(stuffModel);
                }
                tV_AllStuffs.refresh();
            }
        }
        if (array[0].equals("StorageEquipmentModel")) {
            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (stuffModel instanceof StorageEquipmentModel) {
                    tV_AllStuffs.getItems().add(stuffModel);
                }
                tV_AllStuffs.refresh();
            }
        }
        if (array[0].equals("VehicleModel")) {
            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (stuffModel instanceof VehicleModel) {
                    tV_AllStuffs.getItems().add(stuffModel);
                }
                tV_AllStuffs.refresh();
            }
        }
        if (array[0].equals("StuffPrice")) {
            double minimumPrice = Double.parseDouble(array[1]);
            double maximumPrice = Double.parseDouble(array[2]);

            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (minimumPrice <= stuffModel.getStuffPrice() && maximumPrice >= stuffModel.getStuffPrice()) {
                    tV_AllStuffs.getItems().add(stuffModel);
                }
                tV_AllStuffs.refresh();
            }
        }
        if (array[0].equals("averageScore")) {

            int minimumScore = Integer.parseInt(array[1]);
            int maximumScore = Integer.parseInt(array[2]);

            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (minimumScore <= stuffModel.getAverageScore() && maximumScore >= stuffModel.getAverageScore()) {
                    tV_AllStuffs.getItems().add(stuffModel);
                }
                tV_AllStuffs.refresh();
            }
        }
        if (array[0].equals("Is Stuff available")) {
            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (stuffModel.getStuffInventory() > 0) {
                    tV_AllStuffs.getItems().add(stuffModel);
                }
                tV_AllStuffs.refresh();
            }
        }
        if (array[0].equals("CarCompanyName")) {

            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (stuffModel instanceof CarModel) {
                    if (((CarModel) stuffModel).getCompanyName().equals(array[1])) {
                        tV_AllStuffs.getItems().add(stuffModel);
                    }
                    tV_AllStuffs.refresh();
                }
            }
        }
        if (array[0].equals("StorageEquipment capacity")) {

            int orderString1 = Integer.parseInt(array[1]);
            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (stuffModel instanceof StorageEquipmentModel) {
                    if (((StorageEquipmentModel) stuffModel).getCapacity() == orderString1) {
                        tV_AllStuffs.getItems().add(stuffModel);
                    }
                    tV_AllStuffs.refresh();
                }
            }
        }
        if (array[0].equals("Pc cpu model")) {

            String orderString1 = array[1];
            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (stuffModel instanceof PersonalComputerModel) {
                    if (((PersonalComputerModel) stuffModel).getCpuModel().equals(orderString1)) {
                        tV_AllStuffs.getItems().add(stuffModel);
                    }
                    tV_AllStuffs.refresh();
                }
            }
        }
        if (array[0].equals("pc ram capacity")) {
            int orderString1 = Integer.parseInt(array[1]);

            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (stuffModel instanceof PersonalComputerModel) {
                    if (((PersonalComputerModel) stuffModel).getRamCapacity() == orderString1) {
                        tV_AllStuffs.getItems().add(stuffModel);
                    }
                    tV_AllStuffs.refresh();
                }
            }
        }
        if (array[0].equals("penColor")) {

            for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                if (stuffModel instanceof PenModel) {
                    if (((PenModel) stuffModel).getColor().equals(array[1])) {
                        tV_AllStuffs.getItems().add(stuffModel);
                    }
                    tV_AllStuffs.refresh();
                }
            }
        }

    }
        //----------------------------------------------------------------


    @FXML
    void goToAStuffPage(ActionEvent event) throws IOException {
        iD=Integer.parseInt(txt_StuffPageId.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("StuffPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 551, 600);
        Main.stage.setTitle("Intended Stuff");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void purchaseOperation(ActionEvent event) throws IOException {
        for (ClientModel clientModel: AdminController.getClientList())
        {
            if (LoginPageController.clientName.equals(clientModel.getUserName()))
            {
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PurchaseOperation.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 859, 751);
                    Main.stage.setTitle("Purchase page");
                    Main.stage.setScene(scene);
                    Main.stage.show();
            }
        }

    }

    @FXML
    void search(ActionEvent event) {
        tV_AllStuffs.getItems().clear();
        String searchString=txt_Search.getText();
        for (StuffModel stuffModel:AdminModel.getAdminModel().getStuffList())
        {
            if (stuffModel.getStuffName().contains(searchString))
            {
                tV_AllStuffs.getItems().add(stuffModel);
            }
        }
        tV_AllStuffs.refresh();
    }

    @FXML
    void back(ActionEvent event) throws IOException, IOException {
        if (LoginPageController.clientName == null)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("firstPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 765, 555);
            Main.stage.setTitle("Home Page");
            Main.stage.setScene(scene);
            Main.stage.show();
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ClientPanelPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 765, 555);
            Main.stage.setTitle("Login page");
            Main.stage.setScene(scene);
            Main.stage.show();
        }

    }

    @FXML
    void showAllStuff(ActionEvent event) {

        tC_StuffName.setCellValueFactory(new PropertyValueFactory<>("stuffName"));
        tC_StuffId.setCellValueFactory(new PropertyValueFactory<>("stuffId"));
        tC_StuffPrice.setCellValueFactory(new PropertyValueFactory<>("stuffPrice"));
        tC_StuffKInd.setCellValueFactory(new PropertyValueFactory<>("stuffKindModel"));
        tC_StuffInventory.setCellValueFactory(new PropertyValueFactory<>("stuffInventory"));
        tC_AverageScore.setCellValueFactory(new PropertyValueFactory<>("averageScore"));
        tV_AllStuffs.getItems().clear();

        for (StuffModel stuffModel: AdminModel.getAdminModel().getStuffList())
        {
            tV_AllStuffs.getItems().add(stuffModel);
        }
        tV_AllStuffs.refresh();
    }

    @FXML
    void sortByComparable(ActionEvent event) {
        tC_StuffName.setCellValueFactory(new PropertyValueFactory<>("stuffName"));
        tC_StuffId.setCellValueFactory(new PropertyValueFactory<>("stuffId"));
        tC_StuffPrice.setCellValueFactory(new PropertyValueFactory<>("stuffPrice"));
        tC_StuffKInd.setCellValueFactory(new PropertyValueFactory<>("stuffKindModel"));
        tC_StuffInventory.setCellValueFactory(new PropertyValueFactory<>("stuffInventory"));
        tC_AverageScore.setCellValueFactory(new PropertyValueFactory<>("averageScore"));
        ArrayList<StuffModel> temp=new ArrayList<>(AdminModel.getAdminModel().getStuffList());
        temp.sort(StuffModel::compareTo);
        tV_AllStuffs.getItems().clear();
        for (StuffModel stuffModel: temp)
        {
            tV_AllStuffs.getItems().add(stuffModel);
        }
        tV_AllStuffs.refresh();
    }

    @FXML
    void loginCheck(ActionEvent event) {
        if (LoginPageController.clientName==null)
        {
            cBox_LoggedIn.setIndeterminate(true);
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Login");
            alert.setContentText("You haven't already logged in so you can't purchase anything!!");
            alert.show();
        }
        else
        {
            cBox_LoggedIn.setSelected(true);
            btn_Purchase.setDisable(false);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tC_StuffName.setCellValueFactory(new PropertyValueFactory<>("stuffName"));
        tC_StuffId.setCellValueFactory(new PropertyValueFactory<>("stuffId"));
        tC_StuffPrice.setCellValueFactory(new PropertyValueFactory<>("stuffPrice"));
        tC_StuffKInd.setCellValueFactory(new PropertyValueFactory<>("stuffKindModel"));
        tC_StuffInventory.setCellValueFactory(new PropertyValueFactory<>("stuffInventory"));
        tC_AverageScore.setCellValueFactory(new PropertyValueFactory<>("averageScore"));
        tV_AllStuffs.getItems().clear();

        for (StuffModel stuffModel: AdminModel.getAdminModel().getStuffList())
        {
            tV_AllStuffs.getItems().add(stuffModel);
        }
        tV_AllStuffs.refresh();
    }
}
