package com.example.oopgym64.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class AuditFinancialTransactionsAndMembershipData {

    @FXML
    private TableView<AuditRecord> auditTable;
    @FXML
    private TableColumn<AuditRecord, LocalDate> colDate;
    @FXML
    private TableColumn<AuditRecord, String> colType;
    @FXML
    private TableColumn<AuditRecord, Double> colAmount;
    @FXML
    private TableColumn<AuditRecord, String> colStatus;
    @FXML
    private Button btnFlag;
    @FXML
    private Button btnExport;

    private final ObservableList<AuditRecord> auditData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind table columns to model properties
        colDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        colType.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        colAmount.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
        colStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // Add sample data
        auditData.addAll(
                new AuditRecord(LocalDate.now().minusDays(1), "Membership Payment", 500.00, "Completed"),
                new AuditRecord(LocalDate.now().minusDays(2), "Purchase", 200.00, "Pending"),
                new AuditRecord(LocalDate.now().minusDays(3), "Refund", -150.00, "Completed")
        );

        auditTable.setItems(auditData);

        // Button actions
        btnFlag.setOnAction(e -> flagSelected());
        btnExport.setOnAction(e -> exportData());
    }

    private void flagSelected() {
        AuditRecord selected = auditTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Flagged");
            auditTable.refresh();
        } else {
            showAlert("No Selection", "Please select a record to flag.");
        }
    }

    private void exportData() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export Audit Data");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        var file = fileChooser.showSaveDialog(auditTable.getScene().getWindow());

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Date,Type,Amount,Status\n");
                for (AuditRecord record : auditData) {
                    writer.write(String.format("%s,%s,%.2f,%s\n",
                            record.getDate(),
                            record.getType(),
                            record.getAmount(),
                            record.getStatus()));
                }
                showAlert("Export Successful", "Data exported successfully!");
            } catch (IOException e) {
                showAlert("Export Failed", "An error occurred while exporting the data.");
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
