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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PremiumFeaturesController {
    @FXML
    private ComboBox<String> trainerCombo;
    
    @FXML
    private ComboBox<String> trainingTypeCombo;
    
    @FXML
    private DatePicker ptDatePicker;
    
    @FXML
    private ComboBox<String> ptTimeCombo;
    
    @FXML
    private ComboBox<String> ptDurationCombo;
    
    @FXML
    private TextArea ptRequirementsArea;
    
    @FXML
    private ComboBox<String> wellnessServiceCombo;
    
    @FXML
    private ComboBox<String> wellnessDurationCombo;
    
    @FXML
    private DatePicker wellnessDatePicker;
    
    @FXML
    private ComboBox<String> wellnessTimeCombo;
    
    @FXML
    private TextArea wellnessRequestsArea;
    
    @FXML
    private TextField supplementNameField;
    
    @FXML
    private TextField dosageField;
    
    @FXML
    private ComboBox<String> supplementTimeCombo;
    
    @FXML
    private TextArea supplementLogArea;
    
    @FXML
    private VBox supplementHistoryBox;
    
    @FXML
    private ListView<String> supplementHistoryList;
    
    @FXML
    private ComboBox<String> goalTypeCombo;
    
    @FXML
    private TextField targetValueField;
    
    @FXML
    private ComboBox<String> timelineCombo;
    
    @FXML
    private ComboBox<String> priorityCombo;
    
    @FXML
    private TextArea goalDescriptionArea;
    
    @FXML
    private VBox currentGoalsBox;
    
    @FXML
    private VBox goalsList;
    
    @FXML
    private Label statusLabel;
    
    private User currentUser;
    private GymService gymService;
    private List<String> supplementHistory;
    
    public void initializeController(User user, GymService service) {
        this.currentUser = user;
        this.gymService = service;
        this.supplementHistory = new ArrayList<>();
        
        initializeForm();
        loadInitialData();
    }
    
    private void initializeForm() {
        // Personal Training
        trainerCombo.getItems().addAll("Sarah Johnson", "Mike Chen", "Emma Rodriguez");
        trainingTypeCombo.getItems().addAll("Strength Training", "Cardio", "Flexibility", "Weight Loss", "Muscle Building", "Sports Specific");
        ptTimeCombo.getItems().addAll("06:00", "07:00", "08:00", "09:00", "17:00", "18:00", "19:00", "20:00");
        ptDurationCombo.getItems().addAll("30 min", "45 min", "60 min", "90 min");
        
        // Wellness Services
        wellnessServiceCombo.getItems().addAll("Sauna Session", "Massage Therapy", "Steam Room", "Hot Tub");
        wellnessTimeCombo.getItems().addAll("06:00", "07:00", "08:00", "09:00", "17:00", "18:00", "19:00", "20:00");
        wellnessDurationCombo.getItems().addAll("20 min", "30 min", "45 min", "60 min");
        
        // Supplement Tracking
        supplementTimeCombo.getItems().addAll("Before Breakfast", "After Breakfast", "Before Workout", "After Workout", "Before Dinner", "Before Bed");
        
        // Goal Setting
        goalTypeCombo.getItems().addAll("Weight Loss", "Muscle Gain", "Endurance", "Strength", "Flexibility", "General Fitness");
        timelineCombo.getItems().addAll("1 Month", "3 Months", "6 Months", "1 Year");
        priorityCombo.getItems().addAll("Low", "Medium", "High", "Critical");
        
        // Set default values
        ptDatePicker.setValue(LocalDate.now().plusDays(1));
        ptTimeCombo.setValue("18:00");
        ptDurationCombo.setValue("60 min");
        
        wellnessDatePicker.setValue(LocalDate.now().plusDays(1));
        wellnessTimeCombo.setValue("17:00");
        wellnessDurationCombo.setValue("30 min");
        
        goalTypeCombo.setValue("General Fitness");
        timelineCombo.setValue("3 Months");
        priorityCombo.setValue("Medium");
    }
    
    private void loadInitialData() {
        // Load current goals
        loadGoals();
        
        // Load supplement history
        loadSupplementHistory();
    }
    
    @FXML
    private void handleCheckTrainerAvailability() {
        String trainer = trainerCombo.getValue();
        LocalDate date = ptDatePicker.getValue();
        String time = ptTimeCombo.getValue();
        
        if (trainer == null || date == null || time == null) {
            statusLabel.setText("Please select trainer, date, and time");
            return;
        }
        
        // Simulate availability check
        if (date.isAfter(LocalDate.now())) {
            statusLabel.setText("✓ " + trainer + " is available on " + date + " at " + time);
        } else {
            statusLabel.setText("✗ " + trainer + " is not available on " + date + " at " + time);
        }
    }
    
    @FXML
    private void handleBookPersonalTraining() {
        String trainer = trainerCombo.getValue();
        LocalDate date = ptDatePicker.getValue();
        String timeStr = ptTimeCombo.getValue();
        String duration = ptDurationCombo.getValue();
        String requirements = ptRequirementsArea.getText();
        
        if (trainer == null || date == null || timeStr == null || duration == null) {
            statusLabel.setText("Please fill all required fields");
            return;
        }
        
        // Parse time
        String[] timeParts = timeStr.split(":");
        LocalTime time = LocalTime.of(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]));
        LocalDateTime appointmentTime = date.atTime(time);
        
        // Book personal training
        boolean success = gymService.bookPersonalTraining(currentUser.getUserId(), trainer, appointmentTime);
        
        if (success) {
            statusLabel.setText("Personal training session booked successfully with " + trainer + "!");
            clearPersonalTrainingForm();
        } else {
            statusLabel.setText("Failed to book personal training session");
        }
    }
    
    @FXML
    private void handleCheckWellnessAvailability() {
        String service = wellnessServiceCombo.getValue();
        LocalDate date = wellnessDatePicker.getValue();
        String time = wellnessTimeCombo.getValue();
        
        if (service == null || date == null || time == null) {
            statusLabel.setText("Please select service, date, and time");
            return;
        }
        
        // Simulate availability check
        if (date.isAfter(LocalDate.now())) {
            statusLabel.setText("✓ " + service + " is available on " + date + " at " + time);
        } else {
            statusLabel.setText("✗ " + service + " is not available on " + date + " at " + time);
        }
    }
    
    @FXML
    private void handleBookWellness() {
        String service = wellnessServiceCombo.getValue();
        LocalDate date = wellnessDatePicker.getValue();
        String timeStr = wellnessTimeCombo.getValue();
        String duration = wellnessDurationCombo.getValue();
        String requests = wellnessRequestsArea.getText();
        
        if (service == null || date == null || timeStr == null || duration == null) {
            statusLabel.setText("Please fill all required fields");
            return;
        }
        
        // Parse time
        String[] timeParts = timeStr.split(":");
        LocalTime time = LocalTime.of(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]));
        LocalDateTime appointmentTime = date.atTime(time);
        
        // Book wellness service
        boolean success = gymService.bookWellnessLounge(currentUser.getUserId(), service, appointmentTime);
        
        if (success) {
            statusLabel.setText("Wellness service booked successfully!");
            clearWellnessForm();
        } else {
            statusLabel.setText("Failed to book wellness service");
        }
    }
    
    @FXML
    private void handleAddSupplement() {
        String name = supplementNameField.getText().trim();
        String dosage = dosageField.getText().trim();
        String time = supplementTimeCombo.getValue();
        String notes = supplementLogArea.getText().trim();
        
        if (name.isEmpty() || dosage.isEmpty() || time == null) {
            statusLabel.setText("Please fill supplement name, dosage, and time");
            return;
        }
        
        // Create supplement log entry
        String logEntry = String.format("%s - %s at %s - %s", 
            java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("MMM dd")),
            name, dosage, time);
        
        if (!notes.isEmpty()) {
            logEntry += " - Notes: " + notes;
        }
        
        supplementHistory.add(logEntry);
        loadSupplementHistory();
        
        // Clear form
        supplementNameField.clear();
        dosageField.clear();
        supplementLogArea.clear();
        
        statusLabel.setText("Supplement log added successfully!");
    }
    
    @FXML
    private void handleViewSupplementHistory() {
        supplementHistoryBox.setVisible(!supplementHistoryBox.isVisible());
        if (supplementHistoryBox.isVisible()) {
            statusLabel.setText("Supplement history displayed");
        } else {
            statusLabel.setText("Supplement history hidden");
        }
    }
    
    @FXML
    private void handleAddGoal() {
        String goalType = goalTypeCombo.getValue();
        String targetValue = targetValueField.getText().trim();
        String timeline = timelineCombo.getValue();
        String priority = priorityCombo.getValue();
        String description = goalDescriptionArea.getText().trim();
        
        if (goalType == null || targetValue.isEmpty() || timeline == null || priority == null) {
            statusLabel.setText("Please fill all required goal fields");
            return;
        }
        
        // Create goal string
        String goal = String.format("%s: %s (%s priority, %s timeline)", 
            goalType, targetValue, priority, timeline);
        
        if (!description.isEmpty()) {
            goal += " - " + description;
        }
        
        currentUser.getFitnessGoals().add(goal);
        loadGoals();
        
        // Clear form
        targetValueField.clear();
        goalDescriptionArea.clear();
        
        statusLabel.setText("Fitness goal added successfully!");
    }
    
    @FXML
    private void handleGenerateAIGoal() {
        statusLabel.setText("AI goal generation feature coming soon!");
        // This would integrate with an AI service to generate personalized goals
    }
    
    @FXML
    private void handleViewGoals() {
        currentGoalsBox.setVisible(!currentGoalsBox.isVisible());
        if (currentGoalsBox.isVisible()) {
            statusLabel.setText("Current goals displayed");
        } else {
            statusLabel.setText("Current goals hidden");
        }
    }
    
    @FXML
    private void handleViewAllBookings() {
        statusLabel.setText("All bookings view coming soon!");
    }
    
    @FXML
    private void handleExportData() {
        statusLabel.setText("Data export feature coming soon!");
    }
    
    @FXML
    private void handleContactSupport() {
        statusLabel.setText("Support contact feature coming soon!");
    }
    
    @FXML
    private void handleViewTrainerProfile() {
        statusLabel.setText("Trainer profile view coming soon!");
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
    
    private void removeGoal(String goal) {
        currentUser.getFitnessGoals().remove(goal);
        loadGoals();
        statusLabel.setText("Goal removed successfully!");
    }
    
    private void loadSupplementHistory() {
        supplementHistoryList.getItems().clear();
        supplementHistoryList.getItems().addAll(supplementHistory);
    }
    
    private void clearPersonalTrainingForm() {
        ptDatePicker.setValue(LocalDate.now().plusDays(1));
        ptTimeCombo.setValue("18:00");
        ptDurationCombo.setValue("60 min");
        ptRequirementsArea.clear();
    }
    
    private void clearWellnessForm() {
        wellnessDatePicker.setValue(LocalDate.now().plusDays(1));
        wellnessTimeCombo.setValue("17:00");
        wellnessDurationCombo.setValue("30 min");
        wellnessRequestsArea.clear();
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
