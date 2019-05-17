/* AlgaT Projects made by Enea Guidi, Marco Tomasone and Luca Genova */

import Classes.AlertBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    /*  FIELDS  */
    private static Stage currentWindow;
    private static Scene welcomeScene;
    private static Scene tutorialScene;

    /* METHODS */
    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception io)  {
            new AlertBox("I/O Exceptions check that the directory is correct");
            io.printStackTrace();
        } finally {
            System.out.println("Everything went fine, see you next time lucky bastard");
        }
    }

    public void start(Stage primaryStage) throws Exception {
        currentWindow = primaryStage;
        Parent startScreen = FXMLLoader.load(getClass().getResource("UI/Welcome.fxml"));
        setupWelcomeScene(currentWindow, startScreen);
        currentWindow.show();
    }

    public static void setupWelcomeScene(Stage window, Parent startScreen) {
        window.getIcons().add(new Image("Images/appLogo.png"));
        welcomeScene = new Scene(startScreen);
        window.setTitle("AlgaT");
        window.setScene(welcomeScene);
    }

    public void startTutorialEvent(ActionEvent event) throws Exception{
        System.out.println("Start button clicked!");
        Parent tutorialLayout = FXMLLoader.load(getClass().getResource("UI/TutorialScene.fxml"));
        tutorialScene = new Scene(tutorialLayout);
        currentWindow.setScene(tutorialScene);
    }
}