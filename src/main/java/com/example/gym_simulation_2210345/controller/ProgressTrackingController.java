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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProgressTrackingController {
    @FXML
    private DatePicker startDatePicker;
    
    @FXML
    private DatePicker endDatePicker;
    
    @FXML
    private ComboBox<String> quickSelectCombo;
    
    @FXML
    private VBox progressSummarySection;
    
    @FXML
    private Label totalSessionsLabel;
    
    @FXML
    private Label totalHoursLabel;
    
    @FXML
    private Label classesAttendedLabel;
    
    @FXML
    private Label consistencyLabel;
    
    @FXML
    private Label goalProgressLabel;
    
    @FXML
    private Label streakLabel;
    
    @FXML
    private ComboBox<String> sessionFilterCombo;
    
    @FXML
    private TableView<WorkoutSession> workoutHistoryTable;
    
    @FXML
    private VBox classAttendanceBox;
    
    @FXML
    private TextField weightField;
    
    @FXML
    private TextField bodyFatField;
    
    @FXML
    private TextField muscleMassField;
    
    @FXML
    private TextArea metricsNotesArea;
    
    @FXML
    private VBox goalsBox;
    
    @FXML
    private VBox chartsSection;
    
    @FXML
    private Label statusLabel;
    
    private User currentUser;
    private GymService gymService;
    
    public void initializeController(User user, GymService service) {
        this.currentUser = user;
        this.gymService = service;
        
        initializeForm();
        loadInitialData();
    }
    
    private void initializeForm() {
        // Set default date range (last week)
        startDatePicker.setValue(LocalDate.now().minusWeeks(1));
        endDatePicker.setValue(LocalDate.now());
        
        quickSelectCombo.getItems().addAll("Last Week", "Last Month", "Last 3 Months", "Last 6 Months", "This Year");
        quickSelectCombo.setValue("Last Week");
        
        sessionFilterCombo.getItems().addAll("All Sessions", "Cardio", "Strength Training", "Flexibility", "Mixed");
        sessionFilterCombo.setValue("All Sessions");
        
        // Set up quick select listener
        quickSelectCombo.setOnAction(e -> handleQuickSelect());
    }
    
    private void loadInitialData() {
        // Load current metrics
        weightField.setText(String.valueOf(currentUser.getWeight()));
        
        // Load goals
        loadGoals();
    }
    
    @FXML
    private void handleQuickSelect() {
        String selection = quickSelectCombo.getValue();
        LocalDate endDate = LocalDate.now();
        LocalDate startDate;
        
        switch (selection) {
            case "Last Week":
                startDate = endDate.minusWeeks(1);
                break;
            case "Last Month":
                startDate = endDate.minusMonths(1);
                break;
            case "Last 3 Months":
                startDate = endDate.minusMonths(3);
                break;
            case "Last 6 Months":
                startDate = endDate.minusMonths(6);
                break;
            case "This Year":
                startDate = LocalDate.of(endDate.getYear(), 1, 1);
                break;
            default:
                startDate = endDate.minusWeeks(1);
        }
        
        startDatePicker.setValue(startDate);
        endDatePicker.setValue(endDate);
    }
    
    @FXML
    private void handleGenerateReport() {
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        
        if (startDate == null || endDate == null) {
            statusLabel.setText("Please select both start and end dates");
            return;
        }
        
        if (startDate.isAfter(endDate)) {
            statusLabel.setText("Start date must be before end date");
            return;
        }
        
        generateProgressReport(startDate, endDate);
    }
    
    private void generateProgressReport(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);
        
        List<WorkoutSession> sessions = gymService.getUserWorkoutHistory(
            currentUser.getUserId(), startDateTime, endDateTime
        );
        
        // Calculate summary metrics
        int totalSessions = sessions.size();
        int totalMinutes = sessions.stream().mapToInt(s -> {
            if (s.getEndTime() != null && s.getStartTime() != null) {
                return (int) java.time.temporal.ChronoUnit.MINUTES.between(s.getStartTime(), s.getEndTime());
            }
            return 60; // Default 60 minutes if no end time
        }).sum();
        int totalHours = totalMinutes / 60;
        int classesAttended = currentUser.getEnrolledClasses().size();
        
        // Calculate consistency (sessions per week)
        long weeks = java.time.temporal.ChronoUnit.WEEKS.between(startDate, endDate) + 1;
        double consistency = weeks > 0 ? (double) totalSessions / weeks : 0;
        
        // Calculate goal progress (placeholder)
        double goalProgress = Math.min(100, consistency * 20); // Simple calculation
        
        // Calculate streak (placeholder)
        int streak = calculateStreak(sessions);
        
        // Update UI
        totalSessionsLabel.setText(String.valueOf(totalSessions));
        totalHoursLabel.setText(String.valueOf(totalHours));
        classesAttendedLabel.setText(String.valueOf(classesAttended));
        consistencyLabel.setText(String.format("%.1f", consistency));
        goalProgressLabel.setText(String.format("%.0f%%", goalProgress));
        streakLabel.setText(streak + " days");
        
        progressSummarySection.setVisible(true);
        
        // Load detailed data
        loadWorkoutHistory(sessions);
        loadClassAttendance();
        
        statusLabel.setText("Progress report generated successfully!");
    }
    
    private int calculateStreak(List<WorkoutSession> sessions) {
        if (sessions.isEmpty()) return 0;
        
        // Simple streak calculation - consecutive days with sessions
        int streak = 0;
        LocalDate currentDate = LocalDate.now();
        
        for (int i = 0; i < 30; i++) { // Check last 30 days
            LocalDate checkDate = currentDate.minusDays(i);
            boolean hasSession = sessions.stream()
                .anyMatch(s -> s.getStartTime().toLocalDate().equals(checkDate));
            
            if (hasSession) {
                streak++;
            } else {
                break;
            }
        }
        
        return streak;
    }
    
    private void loadWorkoutHistory(List<WorkoutSession> sessions) {
        // This would populate the TableView with session data
        // For now, just show a summary
        statusLabel.setText("Loaded " + sessions.size() + " workout sessions");
    }
    
    private void loadClassAttendance() {
        classAttendanceBox.getChildren().clear();
        
        List<GroupClass> enrolledClasses = currentUser.getEnrolledClasses();
        if (enrolledClasses.isEmpty()) {
            Label noClassesLabel = new Label("No classes enrolled");
            noClassesLabel.setStyle("-fx-font-style: italic; -fx-text-fill: #666;");
            classAttendanceBox.getChildren().add(noClassesLabel);
        } else {
            for (GroupClass groupClass : enrolledClasses) {
                Label classLabel = new Label(groupClass.getClassName() + " - " + 
                    groupClass.getStartTime().format(DateTimeFormatter.ofPattern("MMM dd, HH:mm")));
                classAttendanceBox.getChildren().add(classLabel);
            }
        }
    }
    
    private void loadGoals() {
        goalsBox.getChildren().clear();
        
        List<String> goals = currentUser.getFitnessGoals();
        if (goals.isEmpty()) {
            Label noGoalsLabel = new Label("No fitness goals set");
            noGoalsLabel.setStyle("-fx-font-style: italic; -fx-text-fill: #666;");
            goalsBox.getChildren().add(noGoalsLabel);
        } else {
            for (String goal : goals) {
                Label goalLabel = new Label("• " + goal);
                goalsBox.getChildren().add(goalLabel);
            }
        }
    }
    
    @FXML
    private void handleExportData() {
        statusLabel.setText("Data export feature coming soon!");
    }
    
    @FXML
    private void handleViewClassSchedule() {
        statusLabel.setText("Class schedule view coming soon!");
    }
    
    @FXML
    private void handleAttendanceReport() {
        statusLabel.setText("Attendance report feature coming soon!");
    }
    
    @FXML
    private void handleSaveMetrics() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double bodyFat = bodyFatField.getText().isEmpty() ? 0 : Double.parseDouble(bodyFatField.getText());
            double muscleMass = muscleMassField.getText().isEmpty() ? 0 : Double.parseDouble(muscleMassField.getText());
            
            // Update user metrics
            currentUser.setWeight(weight);
            
            statusLabel.setText("Metrics saved successfully!");
        } catch (NumberFormatException e) {
            statusLabel.setText("Please enter valid numbers for metrics");
        }
    }
    
    @FXML
    private void handleViewTrends() {
        statusLabel.setText("Trend analysis feature coming soon!");
    }
    
    @FXML
    private void handleAddGoal() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Fitness Goal");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter your fitness goal:");
        
        dialog.showAndWait().ifPresent(goal -> {
            if (!goal.trim().isEmpty()) {
                currentUser.getFitnessGoals().add(goal.trim());
                loadGoals();
                statusLabel.setText("Goal added successfully!");
            }
        });
    }
    
    @FXML
    private void handleMarkAchievement() {
        statusLabel.setText("Achievement marking feature coming soon!");
    }
    
    @FXML
    private void handlePrintReport() {
        statusLabel.setText("Print feature coming soon!");
    }
    
    @FXML
    private void handleShareProgress() {
        statusLabel.setText("Progress sharing feature coming soon!");
    }
    
    @FXML
    private void handleSetNewGoals() {
        handleAddGoal();
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
