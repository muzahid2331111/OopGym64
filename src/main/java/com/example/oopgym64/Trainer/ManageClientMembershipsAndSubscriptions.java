package com.example.oopgym64.Trainer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class ManageClientMembershipsAndSubscriptions {

    @FXML private TextField clientIdField;
    @FXML private TextField clientNameField;
    @FXML private ComboBox<String> membershipTypeDropdown;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private ComboBox<String> paymentStatusDropdown;
    @FXML private TextArea notesField;

    @FXML private Button saveButton;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;

    @FXML
    public void initialize() {
        // Populate dropdowns
        membershipTypeDropdown.getItems().addAll("Basic", "Premium", "VIP");
        paymentStatusDropdown.getItems().addAll("Paid", "Unpaid");

        // Button actions
        saveButton.setOnAction(e -> saveMembership());
        updateButton.setOnAction(e -> updateMembership());
        deleteButton.setOnAction(e -> deleteMembership());
    }

    private void saveMembership() {
        String clientId = clientIdField.getText().trim();
        String clientName = clientNameField.getText().trim();
        String membershipType = membershipTypeDropdown.getValue();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        String paymentStatus = paymentStatusDropdown.getValue();
        String notes = notesField.getText().trim();

        if (clientId.isEmpty() || clientName.isEmpty() || membershipType == null || startDate == null || endDate == null) {
            showAlert("Error", "Please fill in all required fields.");
            return;
        }

        String summary = String.format(
                "Client: %s (%s)\nMembership: %s\nStart: %s\nEnd: %s\nPayment: %s\nNotes: %s",
                clientName, clientId, membershipType, startDate, endDate, paymentStatus, notes
        );

        showAlert("Membership Saved", summary);
        clearForm();
    }

    private void updateMembership() {
        showAlert("Info", "Update feature not implemented yet.");
    }

    private void deleteMembership() {
        showAlert("Info", "Delete feature not implemented yet.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearForm() {
        clientIdField.clear();
        clientNameField.clear();
        membershipTypeDropdown.getSelectionModel().clearSelection();
        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
        paymentStatusDropdown.getSelectionModel().clearSelection();
        notesField.clear();
    } @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
        stage.setScene(scene);
        stage.show();
    }
    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
        stage.setScene(scene);
        stage.show();
    }
}
