package com.example.gym_simulation_2210345.controller;

import com.example.gym_simulation_2210345.model.*;
import com.example.gym_simulation_2210345.service.GymService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DashboardController {
    @FXML
    private Label welcomeLabel;
    
    @FXML
    private Label membershipTypeLabel;
    
    @FXML
    private Label monthlyFeeLabel;
    
    @FXML
    private VBox featuresList;
    
    @FXML
    private VBox recentActivityList;
    
    private User currentUser;
    private GymService gymService;
    
    public void initializeUser(User user, GymService service) {
        this.currentUser = user;
        this.gymService = service;
        
        initializeDashboard();
        loadRecentActivity();
    }
    
    private void initializeDashboard() {
        welcomeLabel.setText("Welcome, " + currentUser.getName() + "!");
        membershipTypeLabel.setText("Membership: " + currentUser.getMembershipType());
        monthlyFeeLabel.setText("Monthly Fee: $" + currentUser.getMonthlyFee());
        
        // Display available features
        featuresList.getChildren().clear();
        for (String feature : currentUser.getAvailableFeatures()) {
            Label featureLabel = new Label("✓ " + feature);
            featureLabel.setStyle("-fx-text-fill: #2E7D32; -fx-font-weight: bold;");
            featuresList.getChildren().add(featureLabel);
        }
    }
    
    private void loadRecentActivity() {
        recentActivityList.getChildren().clear();
        
        // Add recent workout sessions
        List<WorkoutSession> recentSessions = currentUser.getWorkoutSessions();
        if (!recentSessions.isEmpty()) {
            Label sessionsLabel = new Label("Recent Workouts:");
            sessionsLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
            recentActivityList.getChildren().add(sessionsLabel);
            
            for (int i = Math.max(0, recentSessions.size() - 3); i < recentSessions.size(); i++) {
                WorkoutSession session = recentSessions.get(i);
                Label sessionLabel = new Label("• " + session.getSessionType() + " - " + 
                    session.getStartTime().format(DateTimeFormatter.ofPattern("MMM dd, HH:mm")));
                recentActivityList.getChildren().add(sessionLabel);
            }
        }
        
        // Add recent class enrollments
        List<GroupClass> recentClasses = currentUser.getEnrolledClasses();
        if (!recentClasses.isEmpty()) {
            Label classesLabel = new Label("Recent Classes:");
            classesLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
            recentActivityList.getChildren().add(classesLabel);
            
            for (int i = Math.max(0, recentClasses.size() - 3); i < recentClasses.size(); i++) {
                GroupClass groupClass = recentClasses.get(i);
                Label classLabel = new Label("• " + groupClass.getClassName() + " - " + 
                    groupClass.getStartTime().format(DateTimeFormatter.ofPattern("MMM dd, HH:mm")));
                recentActivityList.getChildren().add(classLabel);
            }
        }
        
        if (recentActivityList.getChildren().isEmpty()) {
            Label noActivityLabel = new Label("No recent activity. Start your fitness journey today!");
            noActivityLabel.setStyle("-fx-font-style: italic; -fx-text-fill: #666;");
            recentActivityList.getChildren().add(noActivityLabel);
        }
    }
    
    @FXML
    private void handleBookSession() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("session-booking-view.fxml"));
            Parent root = loader.load();
            
            SessionBookingController controller = loader.getController();
            controller.initializeController(currentUser, gymService);
            
            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Book Session - " + currentUser.getName());
            
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Could not open session booking", Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void handleViewClasses() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("group-classes-view.fxml"));
            Parent root = loader.load();
            
            GroupClassesController controller = loader.getController();
            controller.initializeController(currentUser, gymService);
            
            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Group Classes - " + currentUser.getName());
            
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Could not open group classes", Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void handleUpdateProfile() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-management-view.fxml"));
            Parent root = loader.load();
            
            ProfileManagementController controller = loader.getController();
            controller.initializeController(currentUser, gymService);
            
            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Profile Management - " + currentUser.getName());
            
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Could not open profile management", Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void handleWorkoutPlan() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("workout-plan-view.fxml"));
            Parent root = loader.load();
            
            WorkoutPlanController controller = loader.getController();
            controller.initializeController(currentUser, gymService);
            
            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workout Plan - " + currentUser.getName());
            
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Could not open workout plan", Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void handleTrackProgress() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("progress-tracking-view.fxml"));
            Parent root = loader.load();
            
            ProgressTrackingController controller = loader.getController();
            controller.initializeController(currentUser, gymService);
            
            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Progress Tracking - " + currentUser.getName());
            
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Could not open progress tracking", Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    private void handlePremiumFeatures() {
        if (currentUser instanceof PremiumMember) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("premium-features-view.fxml"));
                Parent root = loader.load();
                
                PremiumFeaturesController controller = loader.getController();
                controller.initializeController(currentUser, gymService);
                
                Stage stage = (Stage) welcomeLabel.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Premium Features - " + currentUser.getName());
                
            } catch (Exception e) {
                e.printStackTrace();
                showAlert("Error", "Could not open premium features", Alert.AlertType.ERROR);
            }
        } else {
            showAlert("Premium Feature", "This feature is only available for Premium Members. Upgrade your membership to access personal training, wellness services, and more!", Alert.AlertType.INFORMATION);
        }
    }
    
    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
