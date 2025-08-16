package com.example.gym_simulation_2210345.controller;

import com.example.gym_simulation_2210345.GymSimulationApplication;
import com.example.gym_simulation_2210345.model.User;
import com.example.gym_simulation_2210345.service.GymService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField emailField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Button registerButton;
    
    @FXML
    private Label statusLabel;
    
    @FXML
    private Label regStatusLabel;
    
    @FXML
    private TextField regNameField;
    
    @FXML
    private TextField regEmailField;
    
    @FXML
    private PasswordField regPasswordField;
    
    @FXML
    private ComboBox<String> membershipTypeCombo;
    
    @FXML
    private TabPane tabPane;
    
    private GymService gymService;
    
    @FXML
    public void initialize() {
        gymService = new GymService();
        

        membershipTypeCombo.getItems().addAll("Basic", "Premium");
        membershipTypeCombo.setValue("Basic");
        

        gymService.registerUser("BM001", "John Doe", "john@example.com", "password123", "Basic");
        gymService.registerUser("PM001", "Jane Smith", "jane@example.com", "password123", "Premium");
    }
    
    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();
        
        if (email.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please enter both email and password");
            return;
        }
        
        User user = gymService.loginUser(email, password);
        if (user != null) {
            statusLabel.setText("Login successful!");
            openMainDashboard(user);
        } else {
            statusLabel.setText("Invalid email or password");
        }
    }
    
    @FXML
    private void handleRegister() {
        String name = regNameField.getText();
        String email = regEmailField.getText();
        String password = regPasswordField.getText();
        String membershipType = membershipTypeCombo.getValue();
        
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            regStatusLabel.setText("Please fill all fields");
            return;
        }
        
        String userId = generateUserId(membershipType);
        boolean success = gymService.registerUser(userId, name, email, password, membershipType);
        
        if (success) {
            regStatusLabel.setText("Registration successful! You can now login.");

            regNameField.clear();
            regEmailField.clear();
            regPasswordField.clear();

            tabPane.getSelectionModel().select(0);
        } else {
            regStatusLabel.setText("Registration failed. User might already exist.");
        }
    }
    
    private String generateUserId(String membershipType) {
        String prefix = "BM".equals(membershipType) ? "BM" : "PM";
        return prefix + String.format("%03d", (int)(Math.random() * 1000));
    }
    
    private void openMainDashboard(User user) {
        try {
            FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("com/example/gym_simulation_2210345/dashboard-view.fxml"));
            Parent root = loader.load();
            
            DashboardController dashboardController = loader.getController();
            dashboardController.initializeUser(user, gymService);
            
            Stage stage = (Stage) loginButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Gym Dashboard - " + user.getName());
            
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Error opening dashboard");
        }
    }
}
