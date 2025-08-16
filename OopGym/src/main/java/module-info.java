module com.example.oopgym {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oopgym to javafx.fxml;
    exports com.example.oopgym;
}