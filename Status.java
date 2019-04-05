package src.sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Status extends Overworld {

    public Text displayHealth;
    public Text displayDamage;
    public Text displaySpeed;
    public Button back;
    public Status()
    {

    }
    public void initialize()
    {
        displayHealth.setText(" "+Overworld.playerMHealth+"/"+Overworld.playerCHealth);
        displayDamage.setText(" "+playerDamage);
        displaySpeed.setText(" "+1);

        back.setGraphic(new ImageView("src/sample/Stage/Scene/Back.png"));
    }

    public void goback(ActionEvent e) throws IOException
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
