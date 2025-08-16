package com.example.oopgym64.Receptionist;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HandleVisitorCheckinsController
{
    @javafx.fxml.FXML
    private Label outputShowCheckInLabel;
    @javafx.fxml.FXML
    private TextField checkInTimeTextField;
    @javafx.fxml.FXML
    private TextField contactTextField;
    @javafx.fxml.FXML
    private TextField visitorNameTextField;
    @javafx.fxml.FXML
    private TableColumn<Integer , Visitor> contactCol;
    @javafx.fxml.FXML
    private TableView<Visitor> visitorTableView;
    @javafx.fxml.FXML
    private TableColumn<String, Visitor> nameCol;
    @javafx.fxml.FXML
    private TableColumn<String, Visitor> checkinCol;

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        checkinCol.setCellValueFactory(new PropertyValueFactory<>("timing"));
    }
    ArrayList<Visitor> visitorList = new ArrayList<>();

    @javafx.fxml.FXML
    public void logCheckInButtonOnClick(ActionEvent actionEvent) {
        String name = visitorNameTextField.getText();
        int contact = Integer.parseInt(contactTextField.getText());
        String timing = checkInTimeTextField.getText();
        Visitor visitor = new Visitor(name, contact, timing);
        visitorList.add(visitor);
        visitorTableView.getItems().clear();
        visitorTableView.getItems().addAll(visitorList);

        outputShowCheckInLabel.setText(toString());
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