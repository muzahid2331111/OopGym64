package com.example.oopgym64.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MonitorSystemUsageAndCompliance {

    @FXML
    private TableView<LogEntry> logTable;
    @FXML
    private TableColumn<LogEntry, String> timestampColumn;
    @FXML
    private TableColumn<LogEntry, String> userColumn;
    @FXML
    private TableColumn<LogEntry, String> activityColumn;
    @FXML
    private TableColumn<LogEntry, String> statusColumn;

    @FXML
    private Button refreshButton;
    @FXML
    private Button flagSuspiciousButton;
    @FXML
    private Button generateReportButton;
    @FXML
    private Label statusLabel;

    private final ObservableList<LogEntry> logData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind table columns
        timestampColumn.setCellValueFactory(cell -> cell.getValue().timestampProperty());
        userColumn.setCellValueFactory(cell -> cell.getValue().userProperty());
        activityColumn.setCellValueFactory(cell -> cell.getValue().activityProperty());
        statusColumn.setCellValueFactory(cell -> cell.getValue().statusProperty());

        logTable.setItems(logData);

        // Button actions
        refreshButton.setOnAction(e -> refreshLogs());
        flagSuspiciousButton.setOnAction(e -> flagSuspicious());
        generateReportButton.setOnAction(e -> generateReport());

        // Load initial logs
        refreshLogs();
    }

    private void refreshLogs() {
        logData.clear();
        logData.addAll(
                new LogEntry("2025-08-15 10:00", "Admin", "Login", "Success"),
                new LogEntry("2025-08-15 10:10", "User1", "View Reports", "Success"),
                new LogEntry("2025-08-15 10:20", "User2", "Delete Record", "Suspicious")
        );
        statusLabel.setText("Status: Logs refreshed");
    }

    private void flagSuspicious() {
        LogEntry selected = logTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            statusLabel.setText("Status: Suspicious activity flagged -> " + selected.getActivity());
        } else {
            statusLabel.setText("Status: No activity selected.");
        }
    }

    private void generateReport() {
        statusLabel.setText("Status: Compliance report generated.");
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
