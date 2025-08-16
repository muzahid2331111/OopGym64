package com.example.oopgym64.Trainer;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ConductFitnessAssessmentsAndBodyMeasurements {

    @FXML private TextField clientNameField;
    @FXML private TextField clientIdField;
    @FXML private TextField heightField;
    @FXML private TextField weightField;
    @FXML private TextField bmiField;
    @FXML private TextField bodyFatField;
    @FXML private TextField muscleMassField;
    @FXML private TextField waistField;
    @FXML private TextField hipField;
    @FXML private TextArea notesField;
    @FXML private Button submitButton;
    @FXML private Label titleLabel;

    @FXML
    public void initialize() {
        // Calculate BMI automatically when height or weight changes
        heightField.textProperty().addListener((obs, oldVal, newVal) -> calculateBMI());
        weightField.textProperty().addListener((obs, oldVal, newVal) -> calculateBMI());

        submitButton.setOnAction(e -> submitAssessment());
    }

    private void calculateBMI() {
        try {
            double heightCm = Double.parseDouble(heightField.getText());
            double weightKg = Double.parseDouble(weightField.getText());

            if (heightCm > 0) {
                double heightM = heightCm / 100.0;
                double bmi = weightKg / (heightM * heightM);
                bmiField.setText(String.format("%.2f", bmi));
            }
        } catch (NumberFormatException e) {
            bmiField.setText("");
        }
    }

    private void submitAssessment() {
        String clientName = clientNameField.getText();
        String clientId = clientIdField.getText();
        String height = heightField.getText();
        String weight = weightField.getText();
        String bmi = bmiField.getText();
        String bodyFat = bodyFatField.getText();
        String muscleMass = muscleMassField.getText();
        String waist = waistField.getText();
        String hip = hipField.getText();
        String notes = notesField.getText();

        // Simple validation
        if (clientName.isEmpty() || clientId.isEmpty()) {
            showAlert("Error", "Client Name and ID are required.");
            return;
        }

        // For now, just show confirmation
        String summary = String.format(
                "Assessment submitted for %s (ID: %s)\nHeight: %s cm, Weight: %s kg, BMI: %s\nBody Fat: %s%%, Muscle Mass: %s kg\nWaist: %s cm, Hip: %s cm\nNotes: %s",
                clientName, clientId, height, weight, bmi, bodyFat, muscleMass, waist, hip, notes
        );
        showAlert("Assessment Submitted", summary);

        clearForm();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearForm() {
        clientNameField.clear();
        clientIdField.clear();
        heightField.clear();
        weightField.clear();
        bmiField.clear();
        bodyFatField.clear();
        muscleMassField.clear();
        waistField.clear();
        hipField.clear();
        notesField.clear();
    }
}
