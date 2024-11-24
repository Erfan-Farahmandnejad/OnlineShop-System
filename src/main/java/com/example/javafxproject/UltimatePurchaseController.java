package com.example.javafxproject;

import com.example.Exceptions.InsufficientBalance;
import com.example.Exceptions.InsufficientInventory;
import com.example.Exceptions.InvalidDiscount;
import com.example.controller.AdminController;
import com.example.controller.ClientController;
import com.example.model.Roles.ClientModel;
import com.example.model.UserModelFacilities.DiscountModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UltimatePurchaseController implements Initializable {

    @FXML
    private Button btn_Back;

    @FXML
    private Button btn_SeeDiscounts;

    @FXML
    private Button btn_SubmitDiscounts;

    @FXML
    private Button btn_UndoDiscount;

    @FXML
    private Button btn_ultimatePurchase;

    @FXML
    private HBox hBox_Discounts;

    @FXML
    private TreeView<String> treeV_Prices=new TreeView<String>();

    @FXML
    private TextField txt_Discount=new TextField();

    static private int priceCounter=0;
    static private TreeItem<String> main=new TreeItem<String>("Prices");

    static private double [] price=new double[10];
    public static String txt_DiscountsTemp;
    public ArrayList<DiscountModel>clientDiscounts=new ArrayList<>();

    @FXML
    void applyDiscount(ActionEvent event) {


        treeV_Prices.setRoot(main);
        txt_DiscountsTemp=txt_Discount.getText();

        System.out.println("test: "+txt_Discount.getText());
        ClientController clientController=new ClientController();
        try {
            String result=clientController.ultimatePurchase(LoginPageController.clientName,1);
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Purchase operation");
            alert.setContentText(result);
            alert.show();
        } catch (InsufficientBalance e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient Balance");
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (InsufficientInventory e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("InsufficientInventory");
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (InvalidDiscount e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("InvalidDiscount");
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (InterruptedException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("InterruptedException");
            alert.setContentText(e.getMessage());
            alert.show();
        }


    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PurchaseOperation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 858, 750);
        Main.stage.setTitle("Purchase page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void seeDiscounts(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SeeDiscounts.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 765, 555);
        Main.stage.setTitle("Your Discount page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void ultimatePurchase(ActionEvent event) {
        ClientController clientController=new ClientController();
        try {
            String result=clientController.ultimatePurchase(LoginPageController.clientName,2);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Purchase");
            alert.setContentText(result);
            alert.show();
            for(ClientModel clientModel1:AdminController.getClientList())
            {
                if (clientModel1.getUserName().equals(LoginPageController.clientName))
                {
                    clientModel1.getCart().clear();
                }
            }
        } catch (InsufficientBalance e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient Balance");
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (InsufficientInventory e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("InsufficientInventory");
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (InvalidDiscount  e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("InvalidDiscount");
            alert.setContentText(e.getMessage());
            alert.show();
        }
        catch (InterruptedException e)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("InterruptedException");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }


    //------------------------------------------------------------------------------------------------
    public ArrayList<DiscountModel> enterClientDiscounts()
    {
            String []codes= txt_DiscountsTemp.split("_");
            for (ClientModel clientModel:AdminController.getClientList()) {

                if (clientModel.getUserName().equals(LoginPageController.clientName))
                {
                    for (int i=0;i<codes.length;i++)
                    {
                        for (DiscountModel discountModel:clientModel.getClientDiscounts())
                        {

                            if (discountModel.getDiscountCode().equals(codes[i]))
                            {
                                System.out.println(discountModel.toString());
                                clientDiscounts.add(discountModel);
                            }
                        }
                    }
                    if (clientDiscounts.size()>0)
                    {
                        return clientDiscounts;
                    }
                    try {
                        throw new InvalidDiscount();
                    } catch (InvalidDiscount e) {
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Discount Error");
                        alert.setTitle(e.getMessage());
                        alert.show();
                    }
                }
            }
        return clientDiscounts;}
        //------------------------------------------------------------------------------------------------
        public void effectOfDiscount(double prePrice,double currentPrice) throws InterruptedException {

            TreeItem<String>item1=new TreeItem<String>("price"+priceCounter+" is "+prePrice);
            price[0]=prePrice;
            priceCounter++;
            TreeItem<String>item2=new TreeItem<String>("price"+priceCounter+" is "+currentPrice);
            price[priceCounter]=currentPrice;
            System.out.println("current price1 is:  "+price[priceCounter]);
            main.getChildren().add(item1);
            main.getChildren().add(item2);
            System.out.println("preprice is:"+prePrice+"     currentPrice is:"+currentPrice);
            treeV_Prices.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        treeV_Prices.setRoot(null);
        treeV_Prices.setRoot(main);
        treeV_Prices.refresh();
    }
}
