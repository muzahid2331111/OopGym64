package com.example.oopgym64.Dietetian;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class BuildNutritionPlanController
{

    @javafx.fxml.FXML
    private TextField memberIDTextField;
    @javafx.fxml.FXML
    private ComboBox<String>  mealPlanComboBox;
    @javafx.fxml.FXML
    private TextArea planDetailsTextArea;

    @javafx.fxml.FXML
    public void initialize() {
        mealPlanComboBox.getItems().addAll("Standard Gym Diet" , "High Protein Diet" , "Low Carb Diet" , "Ketogenic Diet" , "Vegan / Plant-Based Diet" , "Vegetarian Diet" , "Paleo Diet" , "Gluten-Free Diet" , "Dairy-Free Diet");
    }
    ArrayList<NutritionPlan> nutritionPlanList = new ArrayList<>();

    @javafx.fxml.FXML
    public void buildPlanButtonOnClick(ActionEvent actionEvent) {
        String memberID = memberIDTextField.getText();
        String mealPlan = mealPlanComboBox.getValue();
        String planDetails = planDetailsTextArea.getText();
        NutritionPlan plan = new NutritionPlan(memberID, planDetails , planDetails);
        nutritionPlanList.add(plan);

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