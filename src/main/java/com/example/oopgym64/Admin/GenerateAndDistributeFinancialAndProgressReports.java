package com.example.oopgym64.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class GenerateAndDistributeFinancialAndProgressReports {

    @FXML
    private ComboBox<String> reportTypeSelector;
    @FXML
    private DatePicker dateFrom;
    @FXML
    private DatePicker dateTo;
    @FXML
    private Button btnGenerate;
    @FXML
    private TextField recipientEmail;
    @FXML
    private Button btnSend;

    @FXML
    public void initialize() {
        // Simple report types
        reportTypeSelector.getItems().addAll("Financial", "Progress", "Attendance");

        // Button handlers
        btnGenerate.setOnAction(e -> System.out.println("Report generated."));
        btnSend.setOnAction(e -> System.out.println("Report sent to " + recipientEmail.getText()));
    }
    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
        stage.setScene(scene);
        stage.show();
    }
}
