package com.example.gym_simulation_2210345.controller;

import com.example.gym_simulation_2210345.model.*;
import com.example.gym_simulation_2210345.service.GymService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WorkoutPlanController {
    @FXML
    private TextField goalField;
    
    @FXML
    private ComboBox<String> experienceCombo;
    
    @FXML
    private CheckBox mondayCheck;
    
    @FXML
    private CheckBox tuesdayCheck;
    
    @FXML
    private CheckBox wednesdayCheck;
    
    @FXML
    private CheckBox thursdayCheck;
    
    @FXML
    private CheckBox fridayCheck;
    
    @FXML
    private CheckBox saturdayCheck;
    
    @FXML
    private CheckBox sundayCheck;
    
    @FXML
    private ComboBox<String> durationCombo;
    
    @FXML
    private VBox currentPlanBox;
    
    @FXML
    private Label planStatusLabel;
    
    @FXML
    private TextArea workoutPlanArea;
    
    @FXML
    private VBox planDetailsSection;
    
    @FXML
    private ComboBox<String> dayCombo;
    
    @FXML
    private ListView<Exercise> exercisesList;
    
    @FXML
    private TextArea progressNotesArea;
    
    @FXML
    private Label statusLabel;
    
    private User currentUser;
    private GymService gymService;
    private WorkoutPlan currentPlan;
    
    public void initializeController(User user, GymService service) {
        this.currentUser = user;
        this.gymService = service;
        
        initializeForm();
        loadCurrentPlan();
    }
    
    private void initializeForm() {
        experienceCombo.getItems().addAll("Beginner", "Intermediate", "Advanced");
        experienceCombo.setValue("Beginner");
        
        durationCombo.getItems().addAll("30 min", "45 min", "60 min", "90 min", "120 min");
        durationCombo.setValue("60 min");
        
        dayCombo.getItems().addAll("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        dayCombo.setValue("Monday");
        
        // Set default workout days
        mondayCheck.setSelected(true);
        wednesdayCheck.setSelected(true);
        fridayCheck.setSelected(true);
    }
    
    private void loadCurrentPlan() {
        currentPlan = currentUser.getWorkoutPlan();
        if (currentPlan != null) {
            displayWorkoutPlan(currentPlan);
            planDetailsSection.setVisible(true);
        } else {
            planStatusLabel.setText("No active workout plan");
            workoutPlanArea.setText("Create a new workout plan to get started!");
            planDetailsSection.setVisible(false);
        }
    }
    
    @FXML
    private void handleCreatePlan() {
        String goal = goalField.getText();
        if (goal.isEmpty()) {
            statusLabel.setText("Please enter a fitness goal");
            return;
        }
        
        // Get selected workout days
        List<String> workoutDays = getSelectedWorkoutDays();
        if (workoutDays.isEmpty()) {
            statusLabel.setText("Please select at least one workout day");
            return;
        }
        
        // Create workout plan
        currentPlan = gymService.createWorkoutPlan(currentUser.getUserId(), goal);
        if (currentPlan != null) {
            // Add workout days
            for (String dayName : workoutDays) {
                WorkoutDay workoutDay = new WorkoutDay("day_" + dayName.toLowerCase(), dayName, "General Fitness");
                currentPlan.addWorkoutDay(workoutDay);
            }
            
            displayWorkoutPlan(currentPlan);
            planDetailsSection.setVisible(true);
            goalField.clear();
            statusLabel.setText("Workout plan created successfully!");
        } else {
            statusLabel.setText("Failed to create workout plan");
        }
    }
    
    @FXML
    private void handleGenerateAIPlan() {
        statusLabel.setText("AI workout plan generation coming soon!");
        // This would integrate with an AI service to generate personalized plans
    }
    
    @FXML
    private void handleEditPlan() {
        if (currentPlan != null) {
            statusLabel.setText("Edit mode activated. Use the form below to modify your plan.");
        } else {
            statusLabel.setText("No plan to edit. Please create a plan first.");
        }
    }
    
    @FXML
    private void handleDeactivatePlan() {
        if (currentPlan != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deactivate Plan");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to deactivate your current workout plan?");
            
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    currentPlan.deactivate();
                    currentPlan = null;
                    loadCurrentPlan();
                    statusLabel.setText("Workout plan deactivated");
                }
            });
        }
    }
    
    @FXML
    private void handleExportPlan() {
        if (currentPlan != null) {
            statusLabel.setText("Plan export feature coming soon!");
        } else {
            statusLabel.setText("No plan to export");
        }
    }
    
    @FXML
    private void handlePreviousWeek() {
        statusLabel.setText("Previous week navigation coming soon!");
    }
    
    @FXML
    private void handleNextWeek() {
        statusLabel.setText("Next week navigation coming soon!");
    }
    
    @FXML
    private void handleAddExercise() {
        String selectedDay = dayCombo.getValue();
        if (selectedDay == null) {
            statusLabel.setText("Please select a day");
            return;
        }
        
        // Create a simple exercise
        Exercise exercise = new Exercise("ex_" + System.currentTimeMillis(), "Push-ups", "Bodyweight");
        
        // Find the workout day and add exercise
        for (WorkoutDay day : currentPlan.getWorkoutDays()) {
            if (day.getDayName().equals(selectedDay)) {
                day.addExercise(exercise);
                break;
            }
        }
        
        refreshExercisesList();
        statusLabel.setText("Exercise added to " + selectedDay);
    }
    
    @FXML
    private void handleEditExercise() {
        Exercise selectedExercise = exercisesList.getSelectionModel().getSelectedItem();
        if (selectedExercise == null) {
            statusLabel.setText("Please select an exercise to edit");
            return;
        }
        
        statusLabel.setText("Exercise editing feature coming soon!");
    }
    
    @FXML
    private void handleRemoveExercise() {
        Exercise selectedExercise = exercisesList.getSelectionModel().getSelectedItem();
        if (selectedExercise == null) {
            statusLabel.setText("Please select an exercise to remove");
            return;
        }
        
        // Remove exercise from the selected day
        String selectedDay = dayCombo.getValue();
        for (WorkoutDay day : currentPlan.getWorkoutDays()) {
            if (day.getDayName().equals(selectedDay)) {
                day.getExercises().remove(selectedExercise);
                break;
            }
        }
        
        refreshExercisesList();
        statusLabel.setText("Exercise removed from " + selectedDay);
    }
    
    @FXML
    private void handleSaveNotes() {
        String notes = progressNotesArea.getText();
        if (currentPlan != null && !notes.isEmpty()) {
            currentPlan.setNotes(notes);
            statusLabel.setText("Progress notes saved successfully!");
        } else {
            statusLabel.setText("No plan to save notes to or notes are empty");
        }
    }
    
    private List<String> getSelectedWorkoutDays() {
        List<String> days = new ArrayList<>();
        if (mondayCheck.isSelected()) days.add("Monday");
        if (tuesdayCheck.isSelected()) days.add("Tuesday");
        if (wednesdayCheck.isSelected()) days.add("Wednesday");
        if (thursdayCheck.isSelected()) days.add("Thursday");
        if (fridayCheck.isSelected()) days.add("Friday");
        if (saturdayCheck.isSelected()) days.add("Saturday");
        if (sundayCheck.isSelected()) days.add("Sunday");
        return days;
    }
    
    private void displayWorkoutPlan(WorkoutPlan plan) {
        planStatusLabel.setText("Active Workout Plan");
        
        StringBuilder sb = new StringBuilder();
        sb.append("Goal: ").append(plan.getGoal()).append("\n\n");
        sb.append("Created: ").append(plan.getStartDate().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"))).append("\n\n");
        
        for (WorkoutDay day : plan.getWorkoutDays()) {
            sb.append(day.getDayName()).append(" - ").append(day.getFocus()).append("\n");
            for (Exercise exercise : day.getExercises()) {
                sb.append("  • ").append(exercise.toString()).append("\n");
            }
            sb.append("\n");
        }
        
        if (plan.getNotes() != null && !plan.getNotes().isEmpty()) {
            sb.append("Notes: ").append(plan.getNotes());
        }
        
        workoutPlanArea.setText(sb.toString());
    }
    
    private void refreshExercisesList() {
        exercisesList.getItems().clear();
        
        String selectedDay = dayCombo.getValue();
        if (selectedDay != null && currentPlan != null) {
            for (WorkoutDay day : currentPlan.getWorkoutDays()) {
                if (day.getDayName().equals(selectedDay)) {
                    exercisesList.getItems().addAll(day.getExercises());
                    break;
                }
            }
        }
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
