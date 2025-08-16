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

public class ScheduleAndManageClientAppointments {

    @FXML private ComboBox<String> clientSelector;
    @FXML private DatePicker datePicker;
    @FXML private TextField timeField;
    @FXML private ComboBox<String> sessionTypeSelector;
    @FXML private TextArea notesArea;
    @FXML private Label conflictLabel;

    @FXML private Button btnCreate;
    @FXML private Button btnReschedule;
    @FXML private Button btnCancel;
    @FXML private Button btnRefresh;

    @FXML private ListView<String> upcomingAppointmentsList;

    private ObservableList<String> appointments = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Sample clients
        clientSelector.setItems(FXCollections.observableArrayList(
                "John Doe", "Jane Smith", "Alice Brown"
        ));

        // Sample session types
        sessionTypeSelector.setItems(FXCollections.observableArrayList(
                "Workout", "Nutrition Consultation", "Assessment"
        ));

        // ListView setup
        upcomingAppointmentsList.setItems(appointments);

        // Button actions
        btnCreate.setOnAction(e -> createAppointment());
        btnReschedule.setOnAction(e -> rescheduleAppointment());
        btnCancel.setOnAction(e -> cancelAppointment());
        btnRefresh.setOnAction(e -> refreshAppointments());
    }

    private void createAppointment() {
        String client = clientSelector.getValue();
        LocalDate date = datePicker.getValue();
        String time = timeField.getText();
        String sessionType = sessionTypeSelector.getValue();

        if (client == null || date == null || time.isEmpty() || sessionType == null) {
            conflictLabel.setText("Please fill all required fields.");
            return;
        }

        String appointment = client + " - " + sessionType + " on " + date + " at " + time;

        // Simple conflict check
        if (appointments.contains(appointment)) {
            conflictLabel.setText("Conflict: Appointment already exists!");
            return;
        }

        appointments.add(appointment);
        conflictLabel.setText("");
        clearForm();
    }

    private void rescheduleAppointment() {
        String selected = upcomingAppointmentsList.getSelectionModel().getSelectedItem();
        if (selected == null) {
            conflictLabel.setText("Select an appointment to reschedule.");
            return;
        }

        appointments.remove(selected);
        createAppointment(); // create new appointment with updated info
    }

    private void cancelAppointment() {
        String selected = upcomingAppointmentsList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            appointments.remove(selected);
            conflictLabel.setText("");
        } else {
            conflictLabel.setText("Select an appointment to cancel.");
        }
    }

    private void refreshAppointments() {
        upcomingAppointmentsList.refresh();
        conflictLabel.setText("Appointments refreshed.");
    }

    private void clearForm() {
        datePicker.setValue(null);
        timeField.clear();
        sessionTypeSelector.setValue(null);
        notesArea.clear();
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
