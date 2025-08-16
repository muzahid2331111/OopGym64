package com.example.gym_simulation_2210345;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GymSimulationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("com/example/gym_simulation_2210345/login-view.fxml"));
            if (fxmlLoader.getLocation() == null) {
                throw new IOException("Could not find login-view.fxml");
            }
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Gym Simulation System");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println("Error loading FXML: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
