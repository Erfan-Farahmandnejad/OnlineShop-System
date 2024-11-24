package com.example.javafxproject;

import com.example.controller.AdminController;
import com.example.model.Roles.ClientModel;
import com.example.model.Stuff.StuffModel;
import com.example.model.UserModelFacilities.PurchaseInvoiceModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuyHistoryController implements Initializable {

    @FXML
    private AnchorPane anch_BuyHistory;

    @FXML
    private Button btn_Back;

    @FXML
    private ImageView img_BuyHistory;

    @FXML
    private ImageView img_logo;

    @FXML
    private TreeView<String> tV_BuyHistory;
    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ClientPanelPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 765, 555);
        Main.stage.setTitle("Login page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String>main=new TreeItem<String>("Invoices");
        tV_BuyHistory.setRoot(main);
        for (ClientModel clientModel: AdminController.getClientList()) {
            if (clientModel.getUserName().equals(LoginPageController.clientName)) {
                if (clientModel.getClientInvoicesList().size()==0)
                {
                    tV_BuyHistory.setAccessibleText("You haven't already bought anything!");
                }
                for (PurchaseInvoiceModel purchaseInvoiceModel: clientModel.getClientInvoicesList())
                {

                    TreeItem <String> treeItem=new TreeItem<String>(purchaseInvoiceModel.toString());
                    main.getChildren().add(treeItem);
                    for (StuffModel stuffModel:purchaseInvoiceModel.getPurchasedStuffsList())
                    {
                        TreeItem <String> treeItem1=new TreeItem<>(stuffModel.toString());
                        treeItem.getChildren().add(treeItem1);
                    }

                }
            }
        }
    }
}
