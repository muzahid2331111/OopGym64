package com.example.oopgym64.Trainer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MonitorClientProgressAndPerformance {

    // Client selector
    @FXML private ComboBox<String> clientSelector;

    // Workout History Table
    @FXML private TableView<WorkoutSession> workoutHistoryTable;
    @FXML private TableColumn<WorkoutSession, String> colDate;
    @FXML private TableColumn<WorkoutSession, String> colSessionType;
    @FXML private TableColumn<WorkoutSession, String> colCompletion;

    // Feedback / Notes
    @FXML private TextArea feedbackArea;

    // Buttons
    @FXML private Button btnAdjustPlan;
    @FXML private Button btnScheduleFollowUp;
    @FXML private Button btnRefresh;

    @FXML
    public void initialize() {
        // Initialize workout history table columns
        colDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        colSessionType.setCellValueFactory(cellData -> cellData.getValue().sessionTypeProperty());
        colCompletion.setCellValueFactory(cellData -> cellData.getValue().completionProperty());

        workoutHistoryTable.setItems(FXCollections.observableArrayList());

        // Sample clients in ComboBox
        clientSelector.setItems(FXCollections.observableArrayList(
                "John Doe", "Jane Smith", "Alice Brown", "Bob Johnson"
        ));

        // Button actions
        btnAdjustPlan.setOnAction(e -> adjustWorkoutPlan());
        btnScheduleFollowUp.setOnAction(e -> scheduleFollowUp());
        btnRefresh.setOnAction(e -> refreshData());
    }

    private void adjustWorkoutPlan() {
        String client = clientSelector.getValue();
        if (client != null) {
            showAlert("Adjust Plan", "Adjusting workout plan for " + client);
        } else {
            showAlert("Adjust Plan", "Please select a client first.");
        }
    }

    private void scheduleFollowUp() {
        String client = clientSelector.getValue();
        if (client != null) {
            showAlert("Schedule Follow-Up", "Scheduling follow-up for " + client);
        } else {
            showAlert("Schedule Follow-Up", "Please select a client first.");
        }
    }

    private void refreshData() {
        showAlert("Refresh Data", "Data refreshed successfully.");
        // In practice, reload data for selected client here
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Inner class for Workout History Table
    public static class WorkoutSession {
        private final javafx.beans.property.SimpleStringProperty date;
        private final javafx.beans.property.SimpleStringProperty sessionType;
        private final javafx.beans.property.SimpleStringProperty completion;

        public WorkoutSession(String date, String sessionType, String completion) {
            this.date = new javafx.beans.property.SimpleStringProperty(date);
            this.sessionType = new javafx.beans.property.SimpleStringProperty(sessionType);
            this.completion = new javafx.beans.property.SimpleStringProperty(completion);
        }

        public javafx.beans.property.SimpleStringProperty dateProperty() { return date; }
        public javafx.beans.property.SimpleStringProperty sessionTypeProperty() { return sessionType; }
        public javafx.beans.property.SimpleStringProperty completionProperty() { return completion; }
    }
    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
        stage.setScene(scene);
        stage.show();
    }
}
