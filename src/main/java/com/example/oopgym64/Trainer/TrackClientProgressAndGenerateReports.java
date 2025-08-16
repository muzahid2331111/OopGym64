package com.example.oopgym64.Trainer;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackClientProgressAndGenerateReports {

    @FXML private ComboBox<String> clientSelector;
    @FXML private ComboBox<String> timeframeSelector;

    @FXML private ProgressBar workoutCompletionBar;
    @FXML private ProgressBar nutritionAdherenceBar;
    @FXML private ProgressBar strengthBar;
    @FXML private ProgressBar enduranceBar;

    @FXML private CheckBox includeGoalsCheck;
    @FXML private CheckBox includeTrendChartsCheck;

    @FXML private Button btnGenerate;
    @FXML private Button btnSchedule;
    @FXML private Button btnDownload;

    @FXML private TextArea notesArea;

    @FXML
    public void initialize() {
        // Sample clients
        clientSelector.setItems(FXCollections.observableArrayList(
                "John Doe", "Jane Smith", "Alice Brown"
        ));

        // Sample timeframes
        timeframeSelector.setItems(FXCollections.observableArrayList(
                "Weekly", "Monthly", "Quarterly"
        ));

        // Set default progress values
        workoutCompletionBar.setProgress(0.0);
        nutritionAdherenceBar.setProgress(0.0);
        strengthBar.setProgress(0.0);
        enduranceBar.setProgress(0.0);

        // Button actions
        btnGenerate.setOnAction(e -> generateReport());
        btnSchedule.setOnAction(e -> scheduleReport());
        btnDownload.setOnAction(e -> downloadReport());
    }

    private void generateReport() {
        String client = clientSelector.getValue();
        String timeframe = timeframeSelector.getValue();

        if (client == null || timeframe == null) {
            showAlert("Please select a client and timeframe.");
            return;
        }

        // Simulate progress updates (replace with real data)
        workoutCompletionBar.setProgress(Math.random());
        nutritionAdherenceBar.setProgress(Math.random());
        strengthBar.setProgress(Math.random());
        enduranceBar.setProgress(Math.random());

        notesArea.appendText("Generated report for " + client + " (" + timeframe + ")\n");
    }

    private void scheduleReport() {
        String client = clientSelector.getValue();
        if (client == null) {
            showAlert("Select a client to schedule reports for.");
            return;
        }
        notesArea.appendText("Scheduled automatic reports for " + client + "\n");
    }

    private void downloadReport() {
        String client = clientSelector.getValue();
        if (client == null) {
            showAlert("Select a client to download report.");
            return;
        }
        notesArea.appendText("Downloaded latest report for " + client + "\n");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
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
