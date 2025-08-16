package com.example.oopgym64.Admin;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CoordinateCommunicationAndNotifications {

    @FXML
    private ComboBox<String> recipientSelector;
    @FXML
    private TextArea messageArea;
    @FXML
    private CheckBox emailCheck;
    @FXML
    private CheckBox smsCheck;
    @FXML
    private CheckBox inAppCheck;
    @FXML
    private Button btnSend;

    @FXML
    public void initialize() {
        // Sample recipients for testing
        recipientSelector.getItems().addAll("Member A", "Member B", "Admin Team");
        recipientSelector.getSelectionModel().selectFirst();

        // Button handler
        btnSend.setOnAction(e -> sendNotification());
    }

    private void sendNotification() {
        String recipient = recipientSelector.getValue();
        String message = messageArea.getText();
        boolean viaEmail = emailCheck.isSelected();
        boolean viaSMS = smsCheck.isSelected();
        boolean viaInApp = inAppCheck.isSelected();

        if (recipient == null || message.trim().isEmpty()) {
            showAlert("Error", "Please select a recipient and enter a message.");
            return;
        }

        StringBuilder channels = new StringBuilder();
        if (viaEmail) channels.append("Email ");
        if (viaSMS) channels.append("SMS ");
        if (viaInApp) channels.append("In-App ");

        if (channels.isEmpty()) {
            showAlert("Error", "Please select at least one channel.");
            return;
        }

        // Simulate sending
        String confirmation = String.format(
                "Message sent to %s via %s:\n\n%s",
                recipient,
                channels.toString().trim(),
                message
        );

        showAlert("Notification Sent", confirmation);

        // Clear input
        messageArea.clear();
        emailCheck.setSelected(false);
        smsCheck.setSelected(false);
        inAppCheck.setSelected(false);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
