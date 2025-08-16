package com.example.oopgym64.Receptionist;

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

public class BookingIssuesController {
    @javafx.fxml.FXML
    private TableView<BookingSession> sessionListTableView;
    @javafx.fxml.FXML
    private TableColumn<BookingSession, String> sessionIDCol;
    @javafx.fxml.FXML
    private TableColumn<BookingSession, String> timeCol;
    @javafx.fxml.FXML
    private TableColumn<BookingSession, String> statusCol;
    @javafx.fxml.FXML
    private TextField searchMemberTextField;
    @javafx.fxml.FXML
    private Label outputShowBookingInfoLabel;

    private ObservableList<BookingSession> bookingData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        sessionIDCol.setCellValueFactory(cellData -> cellData.getValue().sessionIDProperty());
        timeCol.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        statusCol.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // Dummy Data
        bookingData.addAll(
                new BookingSession("S101", "10:00 AM", "Booked"),
                new BookingSession("S102", "11:00 AM", "Pending"),
                new BookingSession("S103", "12:00 PM", "Cancelled")
        );

        sessionListTableView.setItems(bookingData);
    }

    @FXML
    public void updateBookingButtonOnClick(ActionEvent actionEvent) {
        String name = searchMemberTextField.getText().trim();
        if (!name.isEmpty()) {
            BookingSession newSession = new BookingSession("S104", "1:00 PM", "Booked");
            bookingData.add(newSession);
            sessionListTableView.setItems(bookingData);

            outputShowBookingInfoLabel.setText("Booking updated for: " + name);
        } else {
            outputShowBookingInfoLabel.setText("Enter member name to update booking.");
        }
    }

    @FXML
    public void cancelBookingButtonOnClick(ActionEvent actionEvent) {
        BookingSession selected = sessionListTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            bookingData.remove(selected);
            outputShowBookingInfoLabel.setText("Booking canceled: " + selected.getSessionID());
        } else {
            outputShowBookingInfoLabel.setText("Please select a booking to cancel.");
        }
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
