package com.example.gym_simulation_2210345.controller;

import com.example.gym_simulation_2210345.model.User;
import com.example.gym_simulation_2210345.service.GymService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class SessionBookingController {
    @FXML
    private ComboBox<String> sessionTypeCombo;
    
    @FXML
    private DatePicker sessionDatePicker;
    
    @FXML
    private ComboBox<String> sessionTimeCombo;
    
    @FXML
    private ComboBox<String> durationCombo;
    
    @FXML
    private TextArea notesArea;
    
    @FXML
    private ListView<String> availableSlotsList;
    
    @FXML
    private VBox bookingSummaryBox;
    
    @FXML
    private VBox summaryContent;
    
    @FXML
    private Label statusLabel;
    
    private User currentUser;
    private GymService gymService;
    
    public void initializeController(User user, GymService service) {
        this.currentUser = user;
        this.gymService = service;
        
        initializeForm();
        loadAvailableSlots();
    }
    
    private void initializeForm() {
        sessionTypeCombo.getItems().addAll("Cardio", "Strength Training", "Flexibility", "Mixed", "HIIT", "Yoga");
        sessionTimeCombo.getItems().addAll("06:00", "07:00", "08:00", "09:00", "17:00", "18:00", "19:00", "20:00");
        durationCombo.getItems().addAll("30 min", "45 min", "60 min", "90 min", "120 min");
        
        sessionDatePicker.setValue(LocalDate.now());
        sessionTypeCombo.setValue("Cardio");
        sessionTimeCombo.setValue("18:00");
        durationCombo.setValue("60 min");
    }
    
    private void loadAvailableSlots() {
        availableSlotsList.getItems().clear();
        availableSlotsList.getItems().addAll(
            "06:00 - 07:00 (Available)",
            "07:00 - 08:00 (Available)",
            "08:00 - 09:00 (Available)",
            "17:00 - 18:00 (Available)",
            "18:00 - 19:00 (Available)",
            "19:00 - 20:00 (Available)"
        );
    }
    
    @FXML
    private void handleCheckAvailability() {
        LocalDate selectedDate = sessionDatePicker.getValue();
        String selectedTime = sessionTimeCombo.getValue();
        
        if (selectedDate == null || selectedTime == null) {
            statusLabel.setText("Please select both date and time");
            return;
        }
        
        // Check availability logic would go here
        statusLabel.setText("Checking availability for " + selectedDate + " at " + selectedTime + "...");
        
        // Simulate availability check
        if (selectedDate.isAfter(LocalDate.now())) {
            statusLabel.setText("✓ Time slot is available!");
        } else {
            statusLabel.setText("✗ Time slot is not available");
        }
    }
    
    @FXML
    private void handleBookSession() {
        String sessionType = sessionTypeCombo.getValue();
        LocalDate date = sessionDatePicker.getValue();
        String timeStr = sessionTimeCombo.getValue();
        String duration = durationCombo.getValue();
        String notes = notesArea.getText();
        
        if (sessionType == null || date == null || timeStr == null || duration == null) {
            statusLabel.setText("Please fill all required fields");
            return;
        }
        
        // Parse time
        String[] timeParts = timeStr.split(":");
        LocalTime time = LocalTime.of(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]));
        LocalDateTime startTime = date.atTime(time);
        
        // Create booking summary
        showBookingSummary(sessionType, startTime, duration, notes);
    }
    
    private void showBookingSummary(String sessionType, LocalDateTime startTime, String duration, String notes) {
        summaryContent.getChildren().clear();
        
        summaryContent.getChildren().add(new Label("Session Type: " + sessionType));
        summaryContent.getChildren().add(new Label("Date: " + startTime.format(java.time.format.DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy"))));
        summaryContent.getChildren().add(new Label("Time: " + startTime.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")));
        summaryContent.getChildren().add(new Label("Duration: " + duration));
        if (notes != null && !notes.trim().isEmpty()) {
            summaryContent.getChildren().add(new Label("Notes: " + notes));
        }
        
        bookingSummaryBox.setVisible(true);
        statusLabel.setText("Please review and confirm your booking");
    }
    
    @FXML
    private void handleConfirmBooking() {
        String sessionType = sessionTypeCombo.getValue();
        LocalDate date = sessionDatePicker.getValue();
        String timeStr = sessionTimeCombo.getValue();
        
        String[] timeParts = timeStr.split(":");
        LocalTime time = LocalTime.of(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]));
        LocalDateTime startTime = date.atTime(time);
        
        boolean success = gymService.bookGymSession(currentUser.getUserId(), startTime, sessionType);
        
        if (success) {
            statusLabel.setText("Session booked successfully!");
            clearForm();
            bookingSummaryBox.setVisible(false);
        } else {
            statusLabel.setText("Failed to book session. Please try again.");
        }
    }
    
    private void clearForm() {
        sessionDatePicker.setValue(LocalDate.now());
        sessionTypeCombo.setValue("Cardio");
        sessionTimeCombo.setValue("18:00");
        durationCombo.setValue("60 min");
        notesArea.clear();
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
