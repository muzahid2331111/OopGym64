package com.example.oopgym64.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageSchedulingAndResourceAllocationOversight {

    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> resourceSelector;
    @FXML
    private ListView<String> allocationList;
    @FXML
    private Label conflictLabel;
    @FXML
    private Button btnRefresh;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnResolve;

    @FXML
    public void initialize() {
        // Add some sample resources
        resourceSelector.getItems().addAll("Projector", "Meeting Room A", "Lab Equipment");
        resourceSelector.getSelectionModel().selectFirst();

        // Add some sample allocations
        allocationList.getItems().addAll(
                "2025-08-15 - Meeting Room A - Reserved",
                "2025-08-16 - Projector - Reserved"
        );

        // Simple button actions
        btnRefresh.setOnAction(e -> allocationList.getItems().add("Refreshed at " + System.currentTimeMillis()));
        btnEdit.setOnAction(e -> conflictLabel.setText("Edit clicked (demo)."));
        btnResolve.setOnAction(e -> conflictLabel.setText("Conflict resolved (demo)."));
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
}
