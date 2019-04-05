package src.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Overworld.fxml")); //Overworld.fxml is the start
        Stage mainWindow = primaryStage;
        Scene world = new Scene(root,500,650);
        String css = this.getClass().getResource("plains002.css").toExternalForm(); //Plains002.css is the start
        world.getStylesheets().add(css);
        mainWindow.setScene(world);
        mainWindow.setTitle("Sword Maiden");
        mainWindow.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
