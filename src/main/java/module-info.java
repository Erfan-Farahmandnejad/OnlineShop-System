module com.example.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.javafxproject to javafx.fxml;
    opens com.example.model.Stuff to javafx.fxml;
    opens com.example.model.UserModelFacilities to javafx.fxml;
    opens com.example.controller to org.junit ;
    exports com.example.javafxproject;
    exports com.example.model.Stuff;
    exports com.example.model.UserModelFacilities;
    exports com.example.controller;

}