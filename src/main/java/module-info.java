module com.example.gym_simulation_2210345 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gym_simulation_2210345 to javafx.fxml;
    opens com.example.gym_simulation_2210345.controller to javafx.fxml;
    opens com.example.gym_simulation_2210345.model to javafx.fxml;
    opens com.example.gym_simulation_2210345.service to javafx.fxml;
    
    exports com.example.gym_simulation_2210345;
    exports com.example.gym_simulation_2210345.controller;
    exports com.example.gym_simulation_2210345.model;
    exports com.example.gym_simulation_2210345.service;
}