package com.runion.laserbox.gcode.sender.ui.fx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class Ui extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Ui.class.getResource("/UiController.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Scene scene = new Scene(page);

        primaryStage.setTitle("Laserbox Gcode Sender");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
