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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnsureDataSecurityAndBackupProcedures {

    @FXML
    private ListView<String> securityAlertsList;
    @FXML
    private Label lastBackupLabel;
    @FXML
    private Label nextBackupLabel;
    @FXML
    private Button btnRunBackup;
    @FXML
    private Button btnViewPolicies;
    @FXML
    private Button btnRefresh;
    @FXML
    private ProgressBar complianceBar;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @FXML
    public void initialize() {
        // Sample alerts
        securityAlertsList.getItems().addAll(
                "Unauthorized login attempt detected",
                "Firewall updated successfully",
                "Malware scan completed: No threats found"
        );

        complianceBar.setProgress(0.75); // 75% compliance for demo

        btnRunBackup.setOnAction(e -> runBackupNow());
        btnViewPolicies.setOnAction(e -> viewPolicies());
        btnRefresh.setOnAction(e -> refreshData());
    }

    private void runBackupNow() {
        String now = LocalDateTime.now().format(formatter);
        lastBackupLabel.setText(now);

        // Simulate scheduling next backup (next day same time)
        LocalDateTime next = LocalDateTime.now().plusDays(1);
        nextBackupLabel.setText(next.format(formatter));

        showAlert("Backup Completed", "Data backup completed successfully at " + now);
    }

    private void viewPolicies() {
        showAlert("Security Policies",
                "1. Regular malware scans\n" +
                        "2. Multi-factor authentication\n" +
                        "3. Daily data backups\n" +
                        "4. Encrypted storage and transfer");
    }

    private void refreshData() {
        securityAlertsList.getItems().add("System check at " + LocalDateTime.now().format(formatter));
        complianceBar.setProgress(Math.min(1.0, complianceBar.getProgress() + 0.05));
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
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
