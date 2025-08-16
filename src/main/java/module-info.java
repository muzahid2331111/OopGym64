module com.example.oopgym64 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oopgym64 to javafx.fxml;
    exports com.example.oopgym64;
}