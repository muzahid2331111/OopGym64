package com.example.oopgym64.Receptionist;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RespondToPhoneIquiriesController {
    @javafx.fxml.FXML
    private Label lblSearchResult;
    @javafx.fxml.FXML
    private TextField txtCallerName;
    @javafx.fxml.FXML
    private TextField inqueryDetailsTextField;
    @javafx.fxml.FXML
    private Label outputSearchedInfoLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    ArrayList<RespondPhone> respondList = new ArrayList();

    @javafx.fxml.FXML
    public void SearchButtonOnClick(ActionEvent actionEvent) {
        String name = txtCallerName.getText();
        String details = inqueryDetailsTextField.getText();
        RespondPhone respondPhone = new RespondPhone(name, details);
        respondList.add(respondPhone);


    }
    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Receptionist.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
        stage.setScene(scene);
        stage.show();
    }
}