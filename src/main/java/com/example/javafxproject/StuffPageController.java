package com.example.javafxproject;

import com.example.model.Roles.AdminModel;
import com.example.model.Roles.ClientModel;
import com.example.model.Stuff.BicycleKindModel;
import com.example.model.Stuff.BicycleModel;
import com.example.model.Stuff.StuffModel;
import com.example.model.Stuff.VehicleModel;
import com.example.model.UserModelFacilities.CommentModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StuffPageController implements Initializable {

    @FXML
    private AnchorPane anch_Stuff;

    @FXML
    private Button btn_Back;

    @FXML
    private GridPane gP_Information;

    @FXML
    private GridPane gp_Stuff;

    @FXML
    private ImageView img_AStuff;

    @FXML
    private ImageView img_Stuff;

    @FXML
    private Label lbl_ID;

    @FXML
    private Label lbl_Inventory;

    @FXML
    private Label lbl_Kind;

    @FXML
    private Label lbl_Name;

    @FXML
    private Label lbl_Price;

    @FXML
    private Label lbl_Score;

    @FXML
    private Pane pn_Stuff;

    @FXML
    private TableColumn<CommentModel, String> tC_Text;

    @FXML
    private TableColumn<CommentModel, ClientModel> tC_UserName;

    @FXML
    private TableView<CommentModel> tV_Comments;

    @FXML
    void back(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("showAllStuffs.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 891, 700);
        Main.stage.setTitle("Stuffs page");
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tC_Text.setCellValueFactory(new PropertyValueFactory<CommentModel,String>("commentText"));
        tC_UserName.setCellValueFactory(new PropertyValueFactory<CommentModel,ClientModel>("clientModel"));
        tV_Comments.getItems().clear();
        for (StuffModel stuffModel: AdminModel.getAdminModel().getStuffList())
        {
            //------------------------------------------------------------------------------------------------
            if (stuffModel.getStuffId()==ShowAllController.iD)
            {
                for (CommentModel commentModel: stuffModel.getStuffComments())
                {
                    tV_Comments.getItems().add(commentModel);
                }
                //------------------------------------------------------------------------------------------------
                if (stuffModel.getClass().getSimpleName().equals("BicycleModel"))
                {
                    img_AStuff.setImage(new Image("\"C:\\Users\\acer\\IdeaProjects\\first-project-phase2-Erfan-fn\\javafx-project\\src\\main\\resources\\com\\example\\javafxproject\\image\\Bicycle.jpg"));
                }

                if (stuffModel.getClass().getSimpleName().equals("CarModel"))
                {
                    img_AStuff.setImage(new Image("C:\\Users\\acer\\IdeaProjects\\first-project-phase2-Erfan-fn\\javafx-project\\src\\main\\resources\\com\\example\\javafxproject\\image\\Car.jpg"));
                }

                if (stuffModel.getClass().getSimpleName().equals("FlashMemoryModel"))
                {
                    img_AStuff.setImage(new Image("C:\\Users\\acer\\IdeaProjects\\first-project-phase2-Erfan-fn\\javafx-project\\src\\main\\resources\\com\\example\\javafxproject\\image\\FlashMemory.jpg"));
                }

                if (stuffModel.getClass().getSimpleName().equals("FoodModel"))
                {
                    img_AStuff.setImage(new Image("C:\\Users\\acer\\IdeaProjects\\first-project-phase2-Erfan-fn\\javafx-project\\src\\main\\resources\\com\\example\\javafxproject\\image\\food.jpg"));
                }

                if (stuffModel.getClass().getSimpleName().equals("NoteBookModel"))
                {
                    img_AStuff.setImage(new Image("C:\\Users\\acer\\IdeaProjects\\first-project-phase2-Erfan-fn\\javafx-project\\src\\main\\resources\\com\\example\\javafxproject\\image\\NoteBook.jpg"));
                }

                if (stuffModel.getClass().getSimpleName().equals("SsdModel"))
                {
                    img_AStuff.setImage(new Image("C:\\Users\\acer\\IdeaProjects\\first-project-phase2-Erfan-fn\\javafx-project\\src\\main\\resources\\com\\example\\javafxproject\\image\\ssd.jpg"));
                }

                if (stuffModel.getClass().getSimpleName().equals("PencilModel"))
                {
                    img_AStuff.setImage(new Image("C:\\Users\\acer\\IdeaProjects\\first-project-phase2-Erfan-fn\\javafx-project\\src\\main\\resources\\com\\example\\javafxproject\\image\\pencil.jpg"));
                }

                if (stuffModel.getClass().getSimpleName().equals("PenModel"))
                {
                    img_AStuff.setImage(new Image("C:\\Users\\acer\\IdeaProjects\\first-project-phase2-Erfan-fn\\javafx-project\\src\\main\\resources\\com\\example\\javafxproject\\image\\Pen.jpg"));
                }

                if (stuffModel.getClass().getSimpleName().equals("PersonalComputerModel"))
                {
                    img_AStuff.setImage(new Image("C:\\Users\\acer\\IdeaProjects\\first-project-phase2-Erfan-fn\\javafx-project\\src\\main\\resources\\com\\example\\javafxproject\\image\\Pc.jpg"));
                }
                lbl_ID.setText("Id is:"+String.valueOf(stuffModel.getStuffId()));
                lbl_Name.setText("StuffName:"+stuffModel.getStuffName());
                lbl_Inventory.setText("Inventory is:"+String.valueOf(stuffModel.getStuffInventory()));
                lbl_Kind.setText("Stuff Kind:"+stuffModel.getStuffKindModel().getClass().getSimpleName());
                lbl_Price.setText("Price is:"+String.valueOf(stuffModel.getStuffPrice()));
                lbl_Score.setText("Score is:"+String.valueOf(stuffModel.getAverageScore()));
            }
        }
        tV_Comments.refresh();

    }
}
