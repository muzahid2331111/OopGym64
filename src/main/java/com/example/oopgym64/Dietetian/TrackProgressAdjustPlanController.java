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
import java.time.LocalDate;
import java.util.ArrayList;

public class TrackProgressAdjustPlanController
{

    @javafx.fxml.FXML
    private Label outputRecomandLabel;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<LocalDate, TrackProgress> dateCol;
    @javafx.fxml.FXML
    private TextField memberIDTextField;
    @javafx.fxml.FXML
    private TableColumn<String , TrackProgress> memberIDCol;
    @javafx.fxml.FXML
    private TableColumn<Integer, TrackProgress> bmiCol;
    @javafx.fxml.FXML
    private TextField heightTextField;
    @javafx.fxml.FXML
    private TableColumn<Integer, TrackProgress> heightCol;
    @javafx.fxml.FXML
    private TableColumn<Integer, TrackProgress> fatCol;
    @javafx.fxml.FXML
    private TableView<TrackProgress> trackProgressTableView;
    @javafx.fxml.FXML
    private TableColumn<Integer , TrackProgress> weightCol;
    @javafx.fxml.FXML
    private TextField weightTextField;

    @javafx.fxml.FXML
    public void initialize() {
        memberIDCol.setCellValueFactory(new PropertyValueFactory<>("memberID"));
        heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));
        weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        bmiCol.setCellValueFactory(new PropertyValueFactory<>("BMI"));
        fatCol.setCellValueFactory(new PropertyValueFactory<>("fat%"));
    }
    ArrayList<TrackProgress> trackProgressesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void trackProgressButtonOnClick(ActionEvent actionEvent) {
        if (memberIDTextField.getText().trim().isEmpty()){
            outputRecomandLabel.setText("Please enter name");
            return;
        }
        if (heightTextField.getText().trim().isEmpty()){
            outputRecomandLabel.setText("Please add height");
            return;
        }
        if (dateDatePicker.getValue() == null){
            outputRecomandLabel.setText("Please choose date");
            return;
        }
        if (weightTextField.getText().trim().isEmpty()) {
            outputRecomandLabel.setText("Please add weight");
            return;
        }

        String memberID = memberIDTextField.getText();
        double height = Double.parseDouble(heightCol.getText());
        double weight = Double.parseDouble(weightTextField.getText());
        LocalDate date = dateDatePicker.getValue();

        TrackProgress trackProgress = new TrackProgress(memberID, height, weight, date);
        trackProgressesList.add(trackProgress);
        trackProgressTableView.getItems().clear();
        trackProgressTableView.getItems().addAll(trackProgressesList);


    }

    @javafx.fxml.FXML
    public void adjustPlanButtonOnClick(ActionEvent actionEvent) {
        outputRecomandLabel.setText("plan saved");
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