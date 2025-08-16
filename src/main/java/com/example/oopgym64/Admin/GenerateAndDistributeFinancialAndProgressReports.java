package com.example.oopgym64.Admin;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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
}
