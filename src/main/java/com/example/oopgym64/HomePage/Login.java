package com.example.oopgym64.HomePage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @javafx.fxml.FXML
    private TextField confirmPassTextField;
    @javafx.fxml.FXML
    private TextField phoneNumTextField;
    @javafx.fxml.FXML
    private TextField passowardTextField;
    @javafx.fxml.FXML
    private TextField enterEmailTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void createProfileButtonOnClick(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
        stage.setScene(scene);
        stage.show();
    }

    @Deprecated
    public void loginButtonOnClick(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
        stage.setScene(scene);
        stage.show();
    }

    @Deprecated
    public void logoutButtonOnClick(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("logOutProfile.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
        stage.setScene(scene);
        stage.show();
    }

    @Deprecated
    public void loginProfileButtonOnClick(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
        stage.setScene(scene);
        stage.show();

        String memberID = memberIDTextField.getText();
        String email = enterEmailTextField.getText();
        String passoward = passowardTextField.getText();

    }

    @javafx.fxml.FXML
    public void createButtonOnClick(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vogue Gold's Gym Lifestyle Lounge");
        stage.setScene(scene);
        stage.show();

        String email = enterEmailTextField.getText();
        int phone = Integer.parseInt(phoneNumTextField.getText());
        String passoward = passowardTextField.getText();
        String confirmmPass = confirmPassTextField.getText();
    }
}