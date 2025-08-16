package controller;

    import javafx.fxml.FXML;
    import javafx.scene.control.*;
    import model.U8g3PerformanceuptimeModel;

    /** Controller for: Monitor System Performance and Uptime */
    public class U8g3PerformanceuptimeController {
        @FXML private TextField cpuField;
    @FXML private TextField memoryField;
    @FXML private TextField diskField;

        @FXML private Label statusLabel;

@FXML
public void validateInputs() {
    try {
        // Simple validation for numeric fields
        Double.parseDouble(cpuField.getText());Double.parseDouble(memoryField.getText());Double.parseDouble(diskField.getText());
        statusLabel.setText("Validation OK");
    } catch (Exception e) {
        statusLabel.setText("Validation failed: " + e.getMessage());
    }
}

@FXML
public void processData() {
    statusLabel.setText("Processed data for: Monitor System Performance and Uptime");
}

@FXML
public void verifyOrCheck() {
    statusLabel.setText("Verification simulated for: Monitor System Performance and Uptime");
}
    }