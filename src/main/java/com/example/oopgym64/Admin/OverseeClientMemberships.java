package com.example.oopgym64.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class OverseeClientMemberships {

    @FXML private TextField searchField;
    @FXML private Button searchButton;

    @FXML private TableView<ClientMembership> membershipTable;
    @FXML private TableColumn<ClientMembership, String> clientNameColumn;
    @FXML private TableColumn<ClientMembership, String> planTypeColumn;
    @FXML private TableColumn<ClientMembership, String> statusColumn;
    @FXML private TableColumn<ClientMembership, String> endDateColumn;
    @FXML private TableColumn<ClientMembership, String> paymentStatusColumn;

    @FXML private Button renewButton;
    @FXML private Button upgradeButton;
    @FXML private Button suspendButton;
    @FXML private Button cancelButton;

    @FXML private Label summaryLabel;

    private final ObservableList<ClientMembership> membershipData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind table columns
        clientNameColumn.setCellValueFactory(cell -> cell.getValue().clientNameProperty());
        planTypeColumn.setCellValueFactory(cell -> cell.getValue().planTypeProperty());
        statusColumn.setCellValueFactory(cell -> cell.getValue().statusProperty());
        endDateColumn.setCellValueFactory(cell -> cell.getValue().endDateProperty());
        paymentStatusColumn.setCellValueFactory(cell -> cell.getValue().paymentStatusProperty());

        membershipTable.setItems(membershipData);

        // Add dummy data
        membershipData.addAll(
                new ClientMembership("Alice", "Gold", "Active", "2025-12-31", "Paid"),
                new ClientMembership("Bob", "Silver", "Active", "2025-08-31", "Pending"),
                new ClientMembership("Charlie", "Platinum", "Suspended", "2025-10-15", "Paid")
        );

        // Button actions
        searchButton.setOnAction(e -> searchClients());
        renewButton.setOnAction(e -> summaryLabel.setText("Renew clicked"));
        upgradeButton.setOnAction(e -> summaryLabel.setText("Upgrade clicked"));
        suspendButton.setOnAction(e -> summaryLabel.setText("Suspend clicked"));
        cancelButton.setOnAction(e -> summaryLabel.setText("Cancel clicked"));
    }

    private void searchClients() {
        String keyword = searchField.getText().trim().toLowerCase();
        membershipTable.getItems().clear();

        // Simple demo: filter by client name containing keyword
        for (ClientMembership client : membershipData) {
            if (client.getClientName().toLowerCase().contains(keyword)) {
                membershipTable.getItems().add(client);
            }
            @javafx.fxml.FXML
            public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
                Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
                stage.setScene(scene);
                stage.show();
            }