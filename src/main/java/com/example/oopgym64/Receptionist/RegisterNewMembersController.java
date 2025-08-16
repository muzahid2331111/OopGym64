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

public class RegisterNewMembersController
{
    @javafx.fxml.FXML
    private TableColumn<Integer, NewMember> ageCol;
    @javafx.fxml.FXML
    private TableColumn<String, NewMember> receptionistIDCol;
    @javafx.fxml.FXML
    private TextField contactInfoTextField;
    @javafx.fxml.FXML
    private TableColumn<Integer, NewMember> contactCol;
    @javafx.fxml.FXML
    private TableColumn<String , NewMember> nameCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField receptionistIdTextField;
    @javafx.fxml.FXML
    private TableView<NewMember> registerNewMemberTableView;
    @javafx.fxml.FXML
    private Label outputRegistrationLabel;
    @javafx.fxml.FXML
    private TableColumn<String, NewMember> genderCol;
    @javafx.fxml.FXML
    private ToggleGroup Gender;
    @javafx.fxml.FXML
    private TextField ageTextField1;
    @javafx.fxml.FXML
    private RadioButton otherRadioButton;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;
    ArrayList<NewMember> newMemberList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        receptionistIDCol.setCellValueFactory(new PropertyValueFactory<>("receptionistID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    @javafx.fxml.FXML
    public void saveValidateShowButtonOnClick(ActionEvent actionEvent) {

        if ( maleRadioButton.isSelected()) {
            outputRegistrationLabel.setText("Male");
        }
        if (femaleRadioButton.isSelected()) {
            outputRegistrationLabel.setText("Female");
        }
        if (otherRadioButton.isSelected()) {
            outputRegistrationLabel.setText("Others");

        }

        String receptionistID = receptionistIdTextField.getText();
        String name = nameTextField.getText();
        int age = Integer.parseInt(ageTextField1.getText());
        int contact = Integer.parseInt(contactInfoTextField.getText());

        NewMember newMember = new NewMember(receptionistID, name , age, contact);
        newMemberList.add(newMember);
    }

    @javafx.fxml.FXML
    public void clickRegistrationButtonOnClick(ActionEvent actionEvent) {
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