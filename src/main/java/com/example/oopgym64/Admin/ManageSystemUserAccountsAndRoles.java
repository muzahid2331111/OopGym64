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

public class ManageSystemUserAccountsAndRoles {

    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private ChoiceBox<String> roleChoiceBox;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button createUserButton;
    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TableColumn<User, String> roleColumn;
    @FXML
    private Button editButton;
    @FXML
    private Button resetPasswordButton;
    @FXML
    private Button deleteButton;

    private final ObservableList<User> userData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Roles
        roleChoiceBox.getItems().addAll("Admin", "Manager", "Staff");

        // Bind table columns
        nameColumn.setCellValueFactory(cell -> cell.getValue().nameProperty());
        emailColumn.setCellValueFactory(cell -> cell.getValue().emailProperty());
        roleColumn.setCellValueFactory(cell -> cell.getValue().roleProperty());

        userTable.setItems(userData);

        // Add user
        createUserButton.setOnAction(e -> addUser());

        // Edit user
        editButton.setOnAction(e -> editUser());

        // Reset password
        resetPasswordButton.setOnAction(e -> resetPassword());

        // Delete user
        deleteButton.setOnAction(e -> deleteUser());
    }

    private void resetPassword() {
    }

    private void addUser() {
        String name = nameField.getText();
        String email = emailField.getText();
        String role = roleChoiceBox.getValue();
        String password = passwordField.getText();

        if (name.isEmpty() || email.isEmpty() || role == null || password.isEmpty()) {
            showAlert("Error", "All fields must be filled!");
            return;
        }

        userData.add(new User(name, email, role));
        clearForm();
    }

    private void editUser() {
        User selected = userTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setName(nameField.getText());
            selected.setEmail(emailField.getText());
            selected.setRole(roleChoiceBox.getValue());
            userTable.refresh();
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
