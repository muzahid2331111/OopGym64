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
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AssesClientsDietaryHabitsController
{

    @javafx.fxml.FXML
    private TextField memberIDTextField;
    @javafx.fxml.FXML
    private TextArea dietPlanTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }
ArrayList<DietaryHabits> dietaryHabitsList = new ArrayList<>();
    @javafx.fxml.FXML
    public void assignButtonOnClick(ActionEvent actionEvent) {
        String memberID = memberIDTextField.getText();
        String dietPlan = dietPlanTextArea.getText();
        DietaryHabits diethabit = new DietaryHabits(memberID, dietPlan);
        dietaryHabitsList.add(diethabit);
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
}