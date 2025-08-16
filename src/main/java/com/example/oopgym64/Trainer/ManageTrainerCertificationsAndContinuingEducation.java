package com.example.oopgym64.Trainer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ManageTrainerCertificationsAndContinuingEducation {

    // Certifications Table
    @FXML private TableView<Certification> certTable;
    @FXML private TableColumn<Certification, String> colName;
    @FXML private TableColumn<Certification, String> colIssuer;
    @FXML private TableColumn<Certification, String> colExpiry;
    @FXML private TableColumn<Certification, String> colStatus;

    // Buttons
    @FXML private Button btnUpload;
    @FXML private Button btnValidate;

    // Recommended Courses
    @FXML private ListView<String> recommendedCoursesList;

    // Course Progress Table
    @FXML private TableView<CourseProgress> courseProgressTable;
    @FXML private TableColumn<CourseProgress, String> colCourse;
    @FXML private TableColumn<CourseProgress, String> colCEStatus;

    // Compliance
    @FXML private ProgressBar complianceProgress;

    @FXML
    public void initialize() {
        // Initialize Certifications Table
        colName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colIssuer.setCellValueFactory(cellData -> cellData.getValue().issuerProperty());
        colExpiry.setCellValueFactory(cellData -> cellData.getValue().expiryProperty());
        colStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        certTable.setItems(FXCollections.observableArrayList());

        // Initialize Course Progress Table
        colCourse.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
        colCEStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        courseProgressTable.setItems(FXCollections.observableArrayList());

        // Sample recommended courses
        recommendedCoursesList.setItems(FXCollections.observableArrayList(
                "CPR Refresher", "Advanced Strength Training", "Nutrition Basics"
        ));

        // Button actions
        btnUpload.setOnAction(e -> uploadCertification());
        btnValidate.setOnAction(e -> validateCertification());

        // Initial compliance
        complianceProgress.setProgress(0.5);
    }

    private void uploadCertification() {
        showAlert("Upload", "Upload Certification functionality triggered.");
    }

    private void validateCertification() {
        showAlert("Validate", "Validation functionality triggered.");
        complianceProgress.setProgress(Math.min(1.0, complianceProgress.getProgress() + 0.1));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Inner classes for table models
    public static class Certification {
        private final javafx.beans.property.SimpleStringProperty name;
        private final javafx.beans.property.SimpleStringProperty issuer;
        private final javafx.beans.property.SimpleStringProperty expiry;
        private final javafx.beans.property.SimpleStringProperty status;

        public Certification(String name, String issuer, String expiry, String status) {
            this.name = new javafx.beans.property.SimpleStringProperty(name);
            this.issuer = new javafx.beans.property.SimpleStringProperty(issuer);
            this.expiry = new javafx.beans.property.SimpleStringProperty(expiry);
            this.status = new javafx.beans.property.SimpleStringProperty(status);
        }

        public javafx.beans.property.SimpleStringProperty nameProperty() { return name; }
        public javafx.beans.property.SimpleStringProperty issuerProperty() { return issuer; }
        public javafx.beans.property.SimpleStringProperty expiryProperty() { return expiry; }
        public javafx.beans.property.SimpleStringProperty statusProperty() { return status; }
    }

    public static class CourseProgress {
        private final javafx.beans.property.SimpleStringProperty courseName;
        private final javafx.beans.property.SimpleStringProperty status;

        public CourseProgress(String courseName, String status) {
            this.courseName = new javafx.beans.property.SimpleStringProperty(courseName);
            this.status = new javafx.beans.property.SimpleStringProperty(status);
        }

        public javafx.beans.property.SimpleStringProperty courseNameProperty() { return courseName; }
        public javafx.beans.property.SimpleStringProperty statusProperty() { return status; }
    }
}
