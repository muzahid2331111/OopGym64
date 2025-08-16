package com.example.oopgym64.Dietetian;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class EducateNutritionPrinciplesController
{

    @javafx.fxml.FXML
    private TextArea educationContentTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> topicComboBox;
    @javafx.fxml.FXML
    private Label outputContentLabel;

    @javafx.fxml.FXML
    public void initialize() {
        topicComboBox.getItems().addAll("Macronutrients", "Micronutrients", "Hydration", "Energy Balance", "Meal Timing", "Dietary Patterns");
    }

    @javafx.fxml.FXML
    public void publishButtonOnClick(ActionEvent actionEvent) {
        String topic = topicComboBox.getValue();
        String content = educationContentTextArea.getText();

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