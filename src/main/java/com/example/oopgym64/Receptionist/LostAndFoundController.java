package com.example.oopgym64.Receptionist;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class LostAndFoundController
{
    @javafx.fxml.FXML
    private TextField inputDetailsTextField;
    @javafx.fxml.FXML
    private TextField referanceIDTextField;
    @javafx.fxml.FXML
    private TextField memberIDTextField;
    @javafx.fxml.FXML
    private Label outputDisplayReferenceIDLabel;

    @javafx.fxml.FXML
    public void initialize() {

    }
    ArrayList<LostFound> lostFoundList = new ArrayList<>();

    @javafx.fxml.FXML
    public void reportLostItemButtonOnClick(ActionEvent actionEvent) {
        String memberID = memberIDTextField.getText();
        String referenceID = referanceIDTextField.getText();
        String details = inputDetailsTextField.getText();

        LostFound lostFound = new LostFound(memberID, referenceID, details);
        lostFoundList.add(lostFound);
        if (referanceIDTextField.equals(referenceID)) {
            outputDisplayReferenceIDLabel.setText("referenceID : " + referenceID + "item found");
        } else{
            outputDisplayReferenceIDLabel.setText("item's not found");

        }
    }

    @javafx.fxml.FXML
    public void logEntryButtonOnClick(ActionEvent actionEvent) {
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