package pl.polsl.lab.vartan.babayan;

import pl.polsl.lab.vartan.babayan.controllercipher.Controller;
import pl.polsl.lab.vartan.babayan.controllercipher.UIController;
import pl.polsl.lab.vartan.babayan.modelcipher.HomophonicCipher;
import pl.polsl.lab.vartan.babayan.viewcipher.CipherViewer;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class where program starts
 *
 * @author vartan babayan
 * @version 1.0
 */
public class MainMenu extends Application {
    /**
     * start function for javafx
     *
     * @param stage - stage of the current scene
     * @throws IOException - in case of any errors
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UIController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Homophonic Cipher");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * starter point, processing all logic of the program
     *
     * @param args - command line arguments provided by user
     */
    public static void main(String[] args) {
        launch();
    }
}