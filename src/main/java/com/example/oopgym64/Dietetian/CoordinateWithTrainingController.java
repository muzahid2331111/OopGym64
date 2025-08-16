package com.example.oopgym64.Dietetian;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CoordinateWithTrainingController
{

    @javafx.fxml.FXML
    private TextArea discussionTextArea;
    @javafx.fxml.FXML
    private TextField scheduleTextField;
    @javafx.fxml.FXML
    private Label outputShowMealLabel;
    @javafx.fxml.FXML
    private TextField memberIDTextField;
    @javafx.fxml.FXML
    private TextField dietaryTimingTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }
ArrayList<Training> trainingArrayList = new ArrayList<>();
    @javafx.fxml.FXML
    public void sendCoordinationButtonOnClick(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Dietitian.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
        stage.setScene(scene);
        stage.show();
    }
    @javafx.fxml.FXML
    public void validateButtonOnClick(ActionEvent actionEvent) {
        String memberID = memberIDTextField.getText();
        String diettiming = dietaryTimingTextField.getText();
        String discussion = discussionTextArea.getText();
        String schedule = scheduleTextField.getText();
        Dietetian.Training training = new Dietetian.Training(memberID, diettiming, discussion, schedule);
        trainingArrayList.add(training);


    }
}