package com.example.oopgym64.Receptionist;

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

public class FrontDeskSuppliesController
{

    @javafx.fxml.FXML
    private ComboBox<String> priorityComboBox;
    @javafx.fxml.FXML
    private TextField itemNameTextField;
    @javafx.fxml.FXML
    private Label refillStatusLabel;
    @javafx.fxml.FXML
    private TableView<Supplies> suppliesTableView;
    @javafx.fxml.FXML
    private TableColumn<String, Supplies> itemCol;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private TableColumn<Double, Supplies> quantityCol;


    @javafx.fxml.FXML
    public void initialize() {
        itemCol.setCellValueFactory(new PropertyValueFactory<>("item"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }
    ArrayList<Supplies> suppliesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void checkInventoryButtonOnClick(ActionEvent actionEvent) {
        String item = itemNameTextField.getText();
        double quantity = Double.parseDouble(quantityTextField.getText());
        Supplies supplies = new Supplies(item, quantity);

        suppliesList.add(supplies);
        suppliesTableView.getItems().clear();
        suppliesTableView.getItems().addAll(suppliesList);
    }

    @javafx.fxml.FXML
    public void submitRefillButtonOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void validateButtonOnClick(ActionEvent actionEvent) {
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