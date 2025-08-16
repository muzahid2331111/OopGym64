package com.example.gym_simulation_2210345.controller;

import com.example.gym_simulation_2210345.model.GroupClass;
import com.example.gym_simulation_2210345.model.User;
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

import java.util.List;

public class GroupClassesController {
    @FXML
    private ComboBox<String> filterCombo;
    
    @FXML
    private TextField searchField;
    
    @FXML
    private ListView<GroupClass> availableClassesList;
    
    @FXML
    private ListView<GroupClass> enrolledClassesList;
    
    @FXML
    private Label classCountLabel;
    
    @FXML
    private Label enrolledCountLabel;
    
    @FXML
    private VBox classDetailsBox;
    
    @FXML
    private VBox classDetailsContent;
    
    @FXML
    private Label statusLabel;
    
    private User currentUser;
    private GymService gymService;
    private ObservableList<GroupClass> availableClasses;
    private ObservableList<GroupClass> enrolledClasses;
    
    public void initializeController(User user, GymService service) {
        this.currentUser = user;
        this.gymService = service;
        
        initializeForm();
        refreshClasses();
    }
    
    private void initializeForm() {
        availableClasses = FXCollections.observableArrayList();
        enrolledClasses = FXCollections.observableArrayList();
        
        availableClassesList.setItems(availableClasses);
        enrolledClassesList.setItems(enrolledClasses);
        
        filterCombo.getItems().addAll("All Classes", "Cardio", "Strength", "Yoga", "HIIT", "Pilates");
        filterCombo.setValue("All Classes");
        
        // Set up search functionality
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filterClasses();
        });
        
        filterCombo.setOnAction(e -> filterClasses());
    }
    
    private void refreshClasses() {
        availableClasses.clear();
        enrolledClasses.clear();
        
        List<GroupClass> allClasses = gymService.getClassSchedule();
        
        for (GroupClass groupClass : allClasses) {
            if (groupClass.getEnrolledMembers().contains(currentUser.getUserId())) {
                enrolledClasses.add(groupClass);
            } else if (!groupClass.isFull()) {
                availableClasses.add(groupClass);
            }
        }
        
        updateCounts();
    }
    
    private void filterClasses() {
        String searchText = searchField.getText().toLowerCase();
        String filterType = filterCombo.getValue();
        
        availableClasses.clear();
        List<GroupClass> allClasses = gymService.getClassSchedule();
        
        for (GroupClass groupClass : allClasses) {
            if (groupClass.getEnrolledMembers().contains(currentUser.getUserId())) {
                continue; // Skip enrolled classes
            }
            
            if (groupClass.isFull()) {
                continue; // Skip full classes
            }
            
            // Apply search filter
            if (!searchText.isEmpty()) {
                if (!groupClass.getClassName().toLowerCase().contains(searchText) &&
                    !groupClass.getInstructor().toLowerCase().contains(searchText)) {
                    continue;
                }
            }
            
            // Apply type filter
            if (!"All Classes".equals(filterType)) {
                if (!groupClass.getClassName().toLowerCase().contains(filterType.toLowerCase())) {
                    continue;
                }
            }
            
            availableClasses.add(groupClass);
        }
        
        updateCounts();
    }
    
    private void updateCounts() {
        classCountLabel.setText(availableClasses.size() + " classes available");
        enrolledCountLabel.setText(enrolledClasses.size() + " classes enrolled");
    }
    
    @FXML
    private void handleSearch() {
        filterClasses();
    }
    
    @FXML
    private void handleJoinClass() {
        GroupClass selectedClass = availableClassesList.getSelectionModel().getSelectedItem();
        if (selectedClass == null) {
            statusLabel.setText("Please select a class to join");
            return;
        }
        
        boolean success = gymService.joinGroupClass(currentUser.getUserId(), selectedClass.getClassId());
        if (success) {
            statusLabel.setText("Successfully joined " + selectedClass.getClassName());
            refreshClasses();
        } else {
            statusLabel.setText("Failed to join class. Class might be full.");
        }
    }
    
    @FXML
    private void handleLeaveClass() {
        GroupClass selectedClass = enrolledClassesList.getSelectionModel().getSelectedItem();
        if (selectedClass == null) {
            statusLabel.setText("Please select a class to leave");
            return;
        }
        
        boolean success = gymService.leaveGroupClass(currentUser.getUserId(), selectedClass.getClassId());
        if (success) {
            statusLabel.setText("Successfully left " + selectedClass.getClassName());
            refreshClasses();
        } else {
            statusLabel.setText("Failed to leave class");
        }
    }
    
    @FXML
    private void handleViewClassDetails() {
        GroupClass selectedClass = availableClassesList.getSelectionModel().getSelectedItem();
        if (selectedClass == null) {
            statusLabel.setText("Please select a class to view details");
            return;
        }
        
        showClassDetails(selectedClass);
    }
    
    @FXML
    private void handleViewSchedule() {
        // This would show a calendar view of enrolled classes
        statusLabel.setText("Schedule view feature coming soon!");
    }
    
    @FXML
    private void handleCloseDetails() {
        classDetailsBox.setVisible(false);
    }
    
    @FXML
    private void handleJoinFromDetails() {
        // Get the class from the details box and join it
        classDetailsBox.setVisible(false);
        handleJoinClass();
    }
    
    private void showClassDetails(GroupClass groupClass) {
        classDetailsContent.getChildren().clear();
        
        classDetailsContent.getChildren().add(new Label("Class: " + groupClass.getClassName()));
        classDetailsContent.getChildren().add(new Label("Instructor: " + groupClass.getInstructor()));
        classDetailsContent.getChildren().add(new Label("Time: " + groupClass.getStartTime().format(java.time.format.DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm"))));
        classDetailsContent.getChildren().add(new Label("Duration: " + groupClass.getDuration() + " minutes"));
        classDetailsContent.getChildren().add(new Label("Available Spots: " + (groupClass.getMaxCapacity() - groupClass.getEnrolledMembers().size())));
        classDetailsContent.getChildren().add(new Label("Location: " + groupClass.getLocation()));
        
        if (groupClass.getDescription() != null && !groupClass.getDescription().isEmpty()) {
            classDetailsContent.getChildren().add(new Label("Description: " + groupClass.getDescription()));
        }
        
        classDetailsBox.setVisible(true);
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
