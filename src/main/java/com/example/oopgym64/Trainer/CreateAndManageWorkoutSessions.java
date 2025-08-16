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
import java.time.LocalDate;

public class CreateAndManageWorkoutSessions {

    @FXML private TextField sessionTitleField;
    @FXML private DatePicker sessionDatePicker;
    @FXML private TextField startTimeField;
    @FXML private TextField durationField;
    @FXML private TextArea exerciseListArea;
    @FXML private ComboBox<String> clientDropdown;
    @FXML private TextArea notesField;

    @FXML private Button createButton;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML private Label titleLabel;

    @FXML private TableView<WorkoutSession> sessionTable;
    @FXML private TableColumn<WorkoutSession, String> titleColumn;
    @FXML private TableColumn<WorkoutSession, String> dateColumn;
    @FXML private TableColumn<WorkoutSession, String> clientColumn;

    private final ObservableList<WorkoutSession> sessions = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Dummy clients for ComboBox
        clientDropdown.getItems().addAll("Alice", "Bob", "Charlie");

        // Button actions
        createButton.setOnAction(e -> createSession());
        updateButton.setOnAction(e -> updateSession());
        deleteButton.setOnAction(e -> deleteSession());
    }

    private void createSession() {
        String title = sessionTitleField.getText();
        LocalDate date = sessionDatePicker.getValue();
        String startTime = startTimeField.getText();
        String duration = durationField.getText();
        String exercises = exerciseListArea.getText();
        String client = clientDropdown.getValue();
        String notes = notesField.getText();

        if (title.isEmpty() || date == null || client == null) {
            showAlert("Error", "Session Title, Date, and Client are required.");
            return;
        }

        WorkoutSession session = new WorkoutSession(title, date.toString(), startTime, duration, exercises, client, notes);
        sessions.add(session);
        showAlert("Success", "Workout session created for " + client);
        clearForm();
    }

    private void updateSession() {
        showAlert("Info", "Update feature not implemented yet.");
    }

    private void deleteSession() {
        showAlert("Info", "Delete feature not implemented yet.");
    }

    private void clearForm() {
        sessionTitleField.clear();
        sessionDatePicker.setValue(null);
        startTimeField.clear();
        durationField.clear();
        exerciseListArea.clear();
        clientDropdown.getSelectionModel().clearSelection();
        notesField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
