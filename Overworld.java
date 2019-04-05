package src.sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Overworld extends SConnect implements Runnable
{
    //Initialize overworld stats
    protected int firstInitialize = 0;
    //Connection to the Sword Maiden Database
    //Player Base Stats
    protected static int playerLevel, playerMHealth, playerCHealth, playerDamage, playerEXP, playerMStamina, playerCStamina, currentGold;
    protected static int playerASPD = 100;
    //Player Stats Augmented (Used when level up)
    protected static int addtoHP, addtoDamage, addtoStamina, addtoLV = 0;
    //STAGES
    protected boolean plains = true;
    protected boolean mushwoods = false;
    protected boolean pikaforest = false;

    //CURRENT ITEMS


    //IMAGES

    public Button moveforward;
    public Button turnBack;
    public Button searchArea;
    public Button characterInfo;
    public Button petInfo;
    public Button worldMap;

    public Overworld()
    {

    }

    public void initialize()
    {
        //INITIALIZE PLAYER STATS
        if(firstInitialize == 0) {
            playerLevel = getPlayerlist().get(0).getLevel() + addtoLV;
            playerDamage = getPlayerlist().get(0).getDamage() + addtoDamage;
            playerEXP = getPlayerlist().get(0).getExp();
            playerMHealth = getPlayerlist().get(0).getHealth() + addtoHP;
            playerCHealth = getPlayerlist().get(0).getHealth();
            playerMStamina = getPlayerlist().get(0).getStamina() + addtoStamina;
            playerCStamina = getPlayerlist().get(0).getStamina();
            firstInitialize += 1;
        }
         moveforward.setGraphic(new ImageView("src/sample/Stage/Scene/Move On.png"));
         turnBack.setGraphic(new ImageView("src/sample/Stage/Scene/Turn Back.png"));
         searchArea.setGraphic(new ImageView("src/sample/Stage/Scene/Search Area.png"));
         characterInfo.setGraphic(new ImageView("src/sample/Stage/Scene/Character Button.png"));
         petInfo.setGraphic(new ImageView("src/sample/Stage/Scene/Items.png"));
         worldMap.setGraphic(new ImageView("src/sample/Stage/Scene/World Map.png"));
    }
    public void run()
    {

    }


    public void moveOn(ActionEvent event) throws IOException {
        if (plains) {
            Parent newroot = FXMLLoader.load(getClass().getResource("plains.fxml"));
            Scene newscene = new Scene(newroot);
            String css = this.getClass().getResource("Plains002.css").toExternalForm();
            newscene.getStylesheets().add(css);

            //get stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(newscene);
            window.show();
        }
        if (mushwoods) {

        }
        if (pikaforest) {

        }
    }
    public void displayCharacter(ActionEvent e) throws IOException
    {
        Parent newroot = FXMLLoader.load(getClass().getResource("Status Screen.fxml"));
        Scene newscene = new Scene(newroot);
        String css = this.getClass().getResource("Status Screen.css").toExternalForm();
        newscene.getStylesheets().add(css);

        //get stage information
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(newscene);
        window.show();
    }

    public void displayMap(ActionEvent e) throws IOException
    {
        Parent newroot = FXMLLoader.load(getClass().getResource("WorldMap.fxml"));
        Scene newscene = new Scene(newroot, 800, 600);
        String css = this.getClass().getResource("WorldMap.css").toExternalForm();
        newscene.getStylesheets().add(css);
        //get stage information
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(newscene);
        window.show();
    }

}
