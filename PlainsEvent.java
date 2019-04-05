package src.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.Random;

public class PlainsEvent extends Overworld implements Runnable
{
    //Game Message for Plains Event
    @FXML
    Text plainsMsg;

    //Next Message Button
    public Button nextbutton;
    public Button battle;
    //Event number and Progression through event. eventboundary determines the range

    int eventboundary = 1; //15 is the amount of events plains has.
    int event = 0;
    int progression = 0;

    //Monster encounter rate.
    int monsterrange = 2; //10 means there is a 22% chance to encounter a monster every event
    int monsterencounter = 0;

    //Did the event take place? Events happen in order 1 ~ 3. 3 means player completed event line.
    int traveler = 0;
    int child =  0;
    int oldman = 0;

    Random rand = new Random(); //random number seed

    public PlainsEvent()
    {
    }

    public void initialize()
    {
        nextbutton.setGraphic(new ImageView("src/sample/Stage/Scene/Next Button.png"));
        if(plains)
        {
            event = rand.nextInt(eventboundary) + 1;
            eventhandler(event);

            monsterencounter = rand.nextInt(monsterrange)+ 1;
        }
    }

    public void run()
    {

    }

    public void nextmsg() throws IOException
    {
        //Event 1 TREE
        if(event == 1 && traveler == 0) {
            if (!(checknumber(monsterencounter, 1, 2))) {
                switch (progression) {
                    case 0:
                        plainsMsg.setText("You see a traveler in the distance. What will you do?");
                        progression += 1;
                        break;
                    case 1:
                        plainsMsg.setText("You decided to approach the traveler.");
                        progression += 1;
                        break;
                }
            }else
            {
                switch(progression){
                    case 0:
                        plainsMsg.setText("You encountered a monster! prepare for battle!");
                        progression += 1;
                        break;
                    case 1:
                        battle.setGraphic(new ImageView("src/sample/Stage/Scene/Engage.png"));
                        battle.setOpacity(100);
                }
            }
        }
        //If Event 1 happened already
        if(event == 1 && traveler == 1)
            if(!(checknumber(monsterencounter,1, 2))) {
                switch (progression) {
                    case 0:
                        plainsMsg.setText("It's that traveler you met from earlier, what could he be doing here?");
                        progression += 1;
                    case 1:
                        plainsMsg.setText("Will you approach him?");
                }
            }else
            {
                switch(progression){
                    case 0:
                        plainsMsg.setText("You encountered a monster! prepare for battle!");
                        progression+=1;
                    case 1:
                        battle.setGraphic(new ImageView("src/sample/Stage/Scene/Engage.png"));
                        battle.setOpacity(100);
                }
            }
        //End of EVENT 1 TREE

        //Event 2 TREE
        if(event == 2 && child == 0) {
            switch (progression) {
                case 0: plainsMsg.setText("The sound of water rushes near by. This might be a good chance to collect some water.");
                    progression += 1;
                    break;
                case 1: plainsMsg.setText("You decided to gather water for your journey");
                    progression += 1;
                    break;
            }
        }

        if(event == 2 && child ==1){
            switch (progression){
                case 0: plainsMsg.setText("It's that child you met earlier. What could she be doing here?");
                    progression +=1;
                    break;
            }
        }
        //End of EVENT 2 TREE
        //Event 3
        if(event == 3 && oldman == 0){
            switch(progression){
                case 0: plainsMsg.setText("");
                    progression += 1;
                    break;
                case 1: plainsMsg.setText("");
                    progression += 1;
                    break;
            }
        }
        //10 - 15 event
        if(checknumber(event, 10, 15)) {
            switch (progression) {
                case 0: plainsMsg.setText("The sun was bright in the sky. You felt like there was no end to your path.");
                    progression += 1;
                break;
                case 1: plainsMsg.setText("You mustered your will and continued to press onward.");
                    progression += 1;
                break;
            }
        }
    }

    public void eventhandler(int x)
    {
        switch (x) {
        case 1:
            plainsMsg.setText("You decided to move on.");
            break;
            case 2:
                plainsMsg.setText("You decided to move on.");
                break;
    }
        if(checknumber(x,10,15))
        {
            plainsMsg.setText("You walked for some time...");
        }
    }

    public boolean checknumber(int test, int lower, int upper)
    {
        return  upper >= test && test >= lower;
    }

    public void randombattle(ActionEvent e) throws IOException
    {
                        Parent newbattle = FXMLLoader.load(getClass().getResource("SM Battle v2.fxml"));
                        Scene battlescene = new Scene(newbattle);
                        String bcss = this.getClass().getResource("Plains_battle002.css").toExternalForm();
                        battlescene.getStylesheets().add(bcss);

                        //get stage information
                        Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
                        window.setScene(battlescene);
                        window.show();
    }
}