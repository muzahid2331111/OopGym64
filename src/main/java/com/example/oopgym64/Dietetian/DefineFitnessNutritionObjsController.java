package com.example.oopgym64.Dietetian;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class DefineFitnessNutritionObjsController
{
    @javafx.fxml.FXML
    private TextField memberIDTextField;
    @javafx.fxml.FXML
    private TextArea fitnessGoalsTextArea;
    @javafx.fxml.FXML
    private TextArea txtNutritionGoals;
    @javafx.fxml.FXML
    private TextField heightTextField;
    @javafx.fxml.FXML
    private Label outputResultLabel;
    @javafx.fxml.FXML
    private Label weightTextField;
    @javafx.fxml.FXML
    private TableView<TrackProgress> fitnessNutritionTableview;
    @javafx.fxml.FXML
    private TableColumn<TrackProgress, String> memberIDCol;
    @javafx.fxml.FXML
    private TableColumn<TrackProgress, Double> bmiCol;
    @javafx.fxml.FXML
    private TableColumn<TrackProgress, Double> heightCol;
    @javafx.fxml.FXML
    private TableColumn<TrackProgress, Double> weightCol;

    @javafx.fxml.FXML
    public void initialize() {
        memberIDCol.setCellValueFactory(new PropertyValueFactory<>("memberID"));
        heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));
        weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        bmiCol.setCellValueFactory(new PropertyValueFactory<>("BMI"));
    }
    ArrayList<TrackProgress> objectivesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void saveObjectivesButtonOnClick(ActionEvent actionEvent) {
        String memberID = memberIDTextField.getText();
        double height = Double.parseDouble(heightCol.getText());
        double weight = Double.parseDouble(weightTextField.getText());
        double bmi = weight / (height * height);

        if (bmi < 18.5) {
            outputResultLabel.setText("Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 24.9) {
           outputResultLabel.setText("Category: Normal weight");
        } else if (bmi >= 25 && bmi < 29.9) {
           outputResultLabel.setText("Category: Overweight");
        } else {
            outputResultLabel.setText("Category: Obesity");
        }
        TrackProgress objs = new TrackProgress(memberID, height, weight, bmi);
        objectivesList.add(objs);
        fitnessNutritionTableview.getItems().clear();
        fitnessNutritionTableview.getItems().addAll(objectivesList);

    }

    @javafx.fxml.FXML
    public void verifyButtonOnClick(ActionEvent actionEvent) {
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