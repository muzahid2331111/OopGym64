package com.example.oopgym64.Dietetian;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SupplementStrategyController
{

    @javafx.fxml.FXML
    private ComboBox<String> supplementComboBox;
    @javafx.fxml.FXML
    private TextField timingTextField;
    @javafx.fxml.FXML
    private Label outputAdviceLabel;
    @javafx.fxml.FXML
    private TextField memberIDTextField;
    @javafx.fxml.FXML
    private TextField dosageTextField;

    @javafx.fxml.FXML
    public void initialize() {
        supplementComboBox.getItems().addAll("Performance & Recovery", "Health & Wellness", "Pre-Workout Enhancement", "Hydration & Electrolytes", " Special Considerations", "Timing & Integration");
    }
ArrayList<Supplement> supplementArrayList = new ArrayList<>();
    @javafx.fxml.FXML
    public void saveStrategyButtonOnClick(ActionEvent actionEvent) {
        String memberID = memberIDTextField.getText();
        String timing = timingTextField.getText();
        int dosage = Integer.parseInt(dosageTextField.getText());
        String supplement = supplementComboBox.getValue();

        Supplement supply = new Supplement(memberID, dosage, timing, supplement);
        supplementArrayList.add(supply);


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