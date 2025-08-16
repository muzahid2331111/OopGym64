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

public class WalkInMembershipQueryController
{
    @javafx.fxml.FXML
    private Label lblPlanDetails;
    @javafx.fxml.FXML
    private ComboBox<String> durationComboBox;
    @javafx.fxml.FXML
    private TableColumn<String , WalkinMembership> planNameCol;
    @javafx.fxml.FXML
    private TableView<WalkinMembership> PlanTableView;
    @javafx.fxml.FXML
    private TableColumn<String, WalkinMembership> durationCol;
    @javafx.fxml.FXML
    private ComboBox<String> planComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> packageComboBox;
    @javafx.fxml.FXML
    private TableColumn<String, WalkinMembership> packageCol;

    @javafx.fxml.FXML
    public void initialize() {

        planComboBox.getItems().addAll("Gym Only" , "Gym + Group Classes", "Gym + Personal Trainer", "All-Inclusive Package" , "Student Discount Plan" , "Family Membership", "Corporate Membership");
        durationComboBox.getItems().addAll("1 Day Pass", "1 Week" , "2 Weeks" , "1 Month", "3 Months" , "6 Months", "12 Months (Annual)");
        packageComboBox.getItems().addAll("500 BDT – 1 Day Pass (Basic)" , "2,500 BDT – 1 Week Pass (Standard)" , "4,000 BDT – 2 Week Pass (Premium)" , "6,000 BDT – 1 Month (Basic)" , "8,000 BDT – 1 Month (Standard)" , "10,000 BDT – 1 Month (Premium)", "15,000 BDT – 3 Months (Standard)" , "25,000 BDT – 6 Months (Premium)" , "40,000 BDT – 12 Months (VIP)");

        planNameCol.setCellValueFactory(new PropertyValueFactory<>("plan"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        packageCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
    ArrayList<WalkinMembership> walkinMembershipList = new ArrayList<>();

    @javafx.fxml.FXML
    public void findPlansButtonOnClick(ActionEvent actionEvent) {
        String plan = planComboBox.getValue();
        String duration = durationComboBox.getValue();
        String price = packageComboBox.getValue();

        WalkinMembership walkinMembership = new WalkinMembership(plan, duration, price);
        walkinMembershipList.add(walkinMembership);
        PlanTableView.getItems().clear();
        PlanTableView.getItems().addAll(walkinMembershipList);

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