package src.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class WorldMap extends Overworld
{
    public Button goBack;
    public WorldMap()
    {

    }

    public void initialize()
    {
        goBack.setGraphic(new ImageView("src/sample/Stage/Scene/Back.png"));
    }

    public void returnToOverworld(ActionEvent e) throws IOException
    {
        Parent newroot = FXMLLoader.load(getClass().getResource("Overworld.fxml"));
        Scene newscene = new Scene(newroot);
        String css = this.getClass().getResource("Plains002.css").toExternalForm();
        newscene.getStylesheets().add(css);

        //get stage information
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(newscene);
        window.show();
    }
}