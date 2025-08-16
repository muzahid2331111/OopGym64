package com.example.oopgym64.Trainer;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DesignPersonalizedNutritionPlans {

    @FXML private TextField clientNameField;
    @FXML private ComboBox<String> goalDropdown;
    @FXML private TextField caloriesField;
    @FXML private TextField proteinField;
    @FXML private TextField carbsField;
    @FXML private TextField fatsField;
    @FXML private TextArea restrictionsField;
    @FXML private TextArea mealPlanField;
    @FXML private Button saveButton;

    @FXML
    public void initialize() {
        // Populate goal dropdown
        goalDropdown.getItems().addAll("Weight Loss", "Muscle Gain", "Maintenance", "General Health");

        // Button action
        saveButton.setOnAction(e -> saveNutritionPlan());
    }

    private void saveNutritionPlan() {
        String clientName = clientNameField.getText().trim();
        String goal = goalDropdown.getValue();
        String calories = caloriesField.getText().trim();
        String protein = proteinField.getText().trim();
        String carbs = carbsField.getText().trim();
        String fats = fatsField.getText().trim();
        String restrictions = restrictionsField.getText().trim();
        String mealPlan = mealPlanField.getText().trim();

        // Basic validation
        if (clientName.isEmpty() || goal == null) {
            showAlert("Error", "Client Name and Goal are required.");
            return;
        }

        // Build summary
        String summary = String.format(
                "Nutrition Plan for %s\nGoal: %s\nCalories: %s\nProtein: %s g\nCarbs: %s g\nFats: %s g\nRestrictions: %s\nMeal Plan: %s",
                clientName, goal, calories, protein, carbs, fats, restrictions, mealPlan
        );

        showAlert("Nutrition Plan Saved", summary);
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
        goalDropdown.getSelectionModel().clearSelection();
        caloriesField.clear();
        proteinField.clear();
        carbsField.clear();
        fatsField.clear();
        restrictionsField.clear();
        mealPlanField.clear();
    }
}
