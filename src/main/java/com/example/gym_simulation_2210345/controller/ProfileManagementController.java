package com.example.gym_simulation_2210345.controller;

import com.example.gym_simulation_2210345.model.User;
import com.example.gym_simulation_2210345.service.GymService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProfileManagementController {
    @FXML
    private TextField firstNameField;
    
    @FXML
    private TextField lastNameField;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private TextField phoneField;
    
    @FXML
    private DatePicker dateOfBirthPicker;
    
    @FXML
    private ComboBox<String> genderCombo;
    
    @FXML
    private TextArea addressArea;
    
    @FXML
    private TextField emergencyContactField;
    
    @FXML
    private TextField heightField;
    
    @FXML
    private TextField weightField;
    
    @FXML
    private TextField bodyFatField;
    
    @FXML
    private TextField muscleMassField;
    
    @FXML
    private ComboBox<String> activityLevelCombo;
    
    @FXML
    private ComboBox<String> experienceLevelCombo;
    
    @FXML
    private TextArea medicalConditionsArea;
    
    @FXML
    private TextArea allergiesArea;
    
    @FXML
    private TextField newGoalField;
    
    @FXML
    private VBox goalsList;
    
    @FXML
    private ComboBox<String> preferredTimeCombo;
    
    @FXML
    private CheckBox prefMondayCheck;
    
    @FXML
    private CheckBox prefTuesdayCheck;
    
    @FXML
    private CheckBox prefWednesdayCheck;
    
    @FXML
    private CheckBox prefThursdayCheck;
    
    @FXML
    private CheckBox prefFridayCheck;
    
    @FXML
    private CheckBox prefSaturdayCheck;
    
    @FXML
    private CheckBox prefSundayCheck;
    
    @FXML
    private CheckBox emailNotificationsCheck;
    
    @FXML
    private CheckBox smsNotificationsCheck;
    
    @FXML
    private CheckBox reminderNotificationsCheck;
    
    @FXML
    private CheckBox classNotificationsCheck;
    
    @FXML
    private Label membershipTypeLabel;
    
    @FXML
    private Label memberSinceLabel;
    
    @FXML
    private Label monthlyFeeLabel;
    
    @FXML
    private Label nextBillingLabel;
    
    @FXML
    private Label statusLabel;
    
    private User currentUser;
    private GymService gymService;
    
    public void initializeController(User user, GymService service) {
        this.currentUser = user;
        this.gymService = service;
        
        initializeForm();
        loadUserData();
    }
    
    private void initializeForm() {
        genderCombo.getItems().addAll("Male", "Female", "Other", "Prefer not to say");
        
        activityLevelCombo.getItems().addAll("Sedentary", "Lightly Active", "Moderately Active", "Very Active", "Extremely Active");
        activityLevelCombo.setValue("Moderately Active");
        
        experienceLevelCombo.getItems().addAll("Beginner", "Intermediate", "Advanced", "Expert");
        experienceLevelCombo.setValue("Beginner");
        
        preferredTimeCombo.getItems().addAll("Early Morning (5-8 AM)", "Morning (8-11 AM)", "Afternoon (11 AM-3 PM)", "Late Afternoon (3-6 PM)", "Evening (6-9 PM)", "Late Night (9 PM-12 AM)");
        preferredTimeCombo.setValue("Evening (6-9 PM)");
        
        // Set default notification preferences
        emailNotificationsCheck.setSelected(true);
        reminderNotificationsCheck.setSelected(true);
        classNotificationsCheck.setSelected(true);
    }
    
    private void loadUserData() {
        // Load personal information
        String[] nameParts = currentUser.getName().split(" ", 2);
        firstNameField.setText(nameParts.length > 0 ? nameParts[0] : "");
        lastNameField.setText(nameParts.length > 1 ? nameParts[1] : "");
        
        emailField.setText(currentUser.getEmail());
        phoneField.setText(currentUser.getPhoneNumber() != null ? currentUser.getPhoneNumber() : "");
        
        if (currentUser.getDateOfBirth() != null) {
            dateOfBirthPicker.setValue(currentUser.getDateOfBirth());
        }
        
        // Load fitness profile
        heightField.setText(String.valueOf(currentUser.getHeight()));
        weightField.setText(String.valueOf(currentUser.getWeight()));
        
        // Load membership information
        membershipTypeLabel.setText(currentUser.getMembershipType());
        monthlyFeeLabel.setText("$" + currentUser.getMonthlyFee());
        
        if (currentUser.getRegistrationDate() != null) {
            memberSinceLabel.setText(currentUser.getRegistrationDate().format(DateTimeFormatter.ofPattern("MMMM yyyy")));
        }
        
        // Set next billing date (1 month from registration)
        if (currentUser.getRegistrationDate() != null) {
            LocalDate nextBilling = currentUser.getRegistrationDate().plusMonths(1);
            nextBillingLabel.setText(nextBilling.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
        }
        
        // Load goals
        loadGoals();
    }
    
    private void loadGoals() {
        goalsList.getChildren().clear();
        
        for (String goal : currentUser.getFitnessGoals()) {
            HBox goalBox = new HBox(10);
            Label goalLabel = new Label("• " + goal);
            Button removeButton = new Button("Remove");
            removeButton.setOnAction(e -> removeGoal(goal));
            
            goalBox.getChildren().addAll(goalLabel, removeButton);
            goalsList.getChildren().add(goalBox);
        }
    }
    
    @FXML
    private void handleAddGoal() {
        String goal = newGoalField.getText().trim();
        if (!goal.isEmpty()) {
            currentUser.getFitnessGoals().add(goal);
            newGoalField.clear();
            loadGoals();
            statusLabel.setText("Goal added successfully!");
        } else {
            statusLabel.setText("Please enter a goal");
        }
    }
    
    private void removeGoal(String goal) {
        currentUser.getFitnessGoals().remove(goal);
        loadGoals();
        statusLabel.setText("Goal removed successfully!");
    }
    
    @FXML
    private void handleSaveChanges() {
        try {
            // Validate required fields
            if (firstNameField.getText().trim().isEmpty() || lastNameField.getText().trim().isEmpty()) {
                statusLabel.setText("First name and last name are required");
                return;
            }
            
            // Update user information
            String fullName = firstNameField.getText().trim() + " " + lastNameField.getText().trim();
            currentUser.setName(fullName);
            
            if (phoneField.getText() != null && !phoneField.getText().trim().isEmpty()) {
                currentUser.setPhoneNumber(phoneField.getText().trim());
            }
            
            if (dateOfBirthPicker.getValue() != null) {
                currentUser.setDateOfBirth(dateOfBirthPicker.getValue());
            }
            
            if (addressArea.getText() != null && !addressArea.getText().trim().isEmpty()) {
                currentUser.setAddress(addressArea.getText().trim());
            }
            
            // Update fitness metrics
            if (!heightField.getText().trim().isEmpty()) {
                currentUser.setHeight(Double.parseDouble(heightField.getText().trim()));
            }
            
            if (!weightField.getText().trim().isEmpty()) {
                currentUser.setWeight(Double.parseDouble(weightField.getText().trim()));
            }
            
            // Save to service
            boolean success = gymService.updateUserProfile(
                currentUser.getUserId(),
                fullName,
                currentUser.getPhoneNumber(),
                currentUser.getWeight(),
                currentUser.getHeight()
            );
            
            if (success) {
                statusLabel.setText("Profile updated successfully!");
            } else {
                statusLabel.setText("Failed to update profile");
            }
            
        } catch (NumberFormatException e) {
            statusLabel.setText("Please enter valid numbers for height and weight");
        } catch (Exception e) {
            statusLabel.setText("Error updating profile: " + e.getMessage());
        }
    }
    
    @FXML
    private void handleResetToDefault() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Reset Profile");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to reset all profile fields to default values?");
        
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                loadUserData();
                statusLabel.setText("Profile reset to default values");
            }
        });
    }
    
    @FXML
    private void handleExportProfile() {
        statusLabel.setText("Profile export feature coming soon!");
    }
    
    @FXML
    private void handleChangePassword() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Change Password");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter new password:");
        
        dialog.showAndWait().ifPresent(newPassword -> {
            if (!newPassword.trim().isEmpty()) {
                currentUser.setPassword(newPassword.trim());
                statusLabel.setText("Password changed successfully!");
            } else {
                statusLabel.setText("Password cannot be empty");
            }
        });
    }
    
    @FXML
    private void handleBackToDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
            Parent root = loader.load();
            
            DashboardController dashboardController = loader.getController();
            dashboardController.initializeUser(currentUser, gymService);
            
            Stage stage = (Stage) statusLabel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Gym Dashboard - " + currentUser.getName());
            
        } catch (Exception e) {
            e.printStackTrace();
            statusLabel.setText("Error returning to dashboard");
        }
    }
}
