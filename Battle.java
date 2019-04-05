package src.sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import java.awt.event.*;
import java.util.Random;

public class Battle extends Overworld implements Runnable {
    public ImageView monster;
    public Text maxHP, currentHP, displayGold, displayMHP, battleText, displayStage, displayStamina;
    protected Monster enemy;
    private int whichmonster;
    private Thread attackani, idlepose;
    //PARAMETER LISTS FOR MONSTERS

    private int monsterHealth, monsterDamage, monsterEXP, monsterGold;
    //PARAMETER FOR USER PLAYER

    public ImageView displayPlayer, playerattackend;
    //CURRENT STAGE INFO
    private int currentStage;

    //MONSTER IMAGES !!
    private Image slime = new Image("src/sample/Enemy Battlers/Slime001.png");
    private Image bat = new Image("src/sample/Enemy Battlers/Bat001.png");
    private Image bee = new Image("src/sample/Enemy Battlers/Bee001.png");

    public Battle()
    {
        enemy = getMonsterlist().get(0);
    }

    @FXML
    public void initialize()
    {
        currentGold = 0;
        currentStage = 1;

        encounter();
        maxHP.setText("" + playerMHealth);
        currentHP.setText("" + playerCHealth);
        displayGold.setText("" + currentGold);
        displayStamina.setText("  "+ playerMStamina+"/"+playerCStamina);
        displayStage.setText("STAGE "+currentStage);

        whichmonster = 0;
        idlepose = new Thread(this);
        idlepose.start();
    }

    public void sAniStart() {
        whichmonster += 1;
        if(whichmonster == 1) {
            attackani = new Thread(this);
            attackani.start();
            switch (enemy.getID()) {
                case 1:
                    sAniEnd();
                    break;
                case 2:
                    sAniEnd();
                    break;
                case 3:
                    sAniEnd();
                    break;
                default:
                    System.out.println("Error no monster?");
            }
        }
    }

    public void sAniEnd()
    {
        switch(enemy.getID()){
            case 1: monster.setImage(slime);
                break;
            case 2: monster.setImage(bat);
                    System.out.println("You dealed "+playerDamage+" damage on "+enemy.getName()+"!!");
                break;
            case 3: monster.setImage(bee);
                    System.out.println("You dealed "+playerDamage+" damage on "+enemy.getName()+"!!");
                break;
            default: System.out.println("Error no monster?");
        }
    }

    public void monsterSlain()
    {
        if(playerCStamina != 0) {
            playerCStamina = playerCStamina;
            monsterHealth = monsterHealth - playerDamage;
            displayMHP.setText("" + monsterHealth);
            displayStamina.setText("  " + playerMStamina + "/" + playerCStamina);
            if (monsterHealth > 0)
                battleText.setText("You dealed " + playerDamage + " damage on " + enemy.getName() + "!!");
            else {
                battleText.setText("You dealed " + playerDamage + " damage on " + enemy.getName() + "!!" + "\nYou have defeated a " + enemy.getName() + "!!\n");
                modifyPlayer();
                encounter();
            }
        }
        else
        {
            battleText.setText("You have no stamina!!");
        }

    }

    public void modifyPlayer()
    {
        currentGold = currentGold+enemy.getGold();
        displayGold.setText("" + currentGold);
        playerEXP = playerEXP-enemy.getExp();

        System.out.println("You gained "+enemy.getGold()+"Gold and "+enemy.getExp()+" Experience!\n" +
                playerEXP+ " experience left until next level up.");
    }
    public void encounter()
    {
        Random rand = new Random();
        int index = rand.nextInt(getMonsterlist().size());
        enemy = setMonster(getMonsterlist().get(index));
    }

    public Monster setMonster(Monster m)
    {
        switch(m.getID()){
            case 1: monster.setImage(slime);
                    initializeMonster(m.getID());
                    break;
            case 2: monster.setImage(bat);
                    initializeMonster(m.getID());
                    break;
            case 3: monster.setImage(bee);
                    initializeMonster(m.getID());
                    break;
            default: System.out.println("No monster??");
        }
        return m;
    }

    public void initializeMonster(int id)
    {
        monsterHealth = getMonsterlist().get(id-1).getHealth();
        monsterDamage = getMonsterlist().get(id-1).getDamage();
        monsterEXP = getMonsterlist().get(id-1).getExp();
        monsterGold = getMonsterlist().get(id-1).getGold();

        displayMHP.setText("" + monsterHealth);
        battleText.setText("A "+getMonsterlist().get(id-1).getName()+" has appeared!!!");
    }

    public void displayInfo()
    {

    }

    public void idleposestart()
    {
            try{
                while(whichmonster == 0) {
                    displayPlayer.setImage(new Image("src/sample/Player Battler/Battle Start/Frame002.png"));
                    Thread.sleep(200);

                    displayPlayer.setImage(new Image("src/sample/Player Battler/Battle Start/Frame003.png"));
                    Thread.sleep(150);

                    displayPlayer.setImage(new Image("src/sample/Player Battler/Battle Start/Frame004.png"));
                    Thread.sleep(150);

                    displayPlayer.setImage(new Image("src/sample/Player Battler/Battle Start/Frame003.png"));
                    Thread.sleep(150);
                }
            }catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
    }
    public void run(){
        if(whichmonster == 0){
            try{
                idleposestart();
            }catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        else if(whichmonster == 1) {
            try {
                displayPlayer.setOpacity(100);
                displayPlayer.setImage(new Image("src/sample/Player Battler/Battle Start/Frame001.png"));
                Thread.sleep(200);
                displayPlayer.setImage(new Image("src/sample/Player Battler/Battle Start/Frame002.png"));
                Thread.sleep(100);
                displayPlayer.setImage(new Image("src/sample/Player Battler/Battle Start/Frame003.png"));
                Thread.sleep(50);
                displayPlayer.setImage(new Image("src/sample/Player Battler/Battle Start/Frame004.png"));
                Thread.sleep(70);
                displayPlayer.setImage(new Image("src/sample/Player Battler/Battle Start/Frame005.png"));
                displayPlayer.setOpacity(75);
                Thread.sleep(70);
                displayPlayer.setImage(new Image("src/sample/Player Battler/Battle Start/Frame006.png"));
                displayPlayer.setOpacity(30);
                Thread.sleep(70);
                displayPlayer.setImage(new Image("src/sample/Player Battler/Battle Start/Frame007.png"));
                displayPlayer.setOpacity(0);
                Thread.sleep(65);

                playerattackend.setOpacity(30);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame001.png"));
                Thread.sleep(70);
                playerattackend.setOpacity(60);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame002.png"));
                Thread.sleep(70);
                playerattackend.setOpacity(90);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame003.png"));
                Thread.sleep(70);
                playerattackend.setOpacity(100);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame004.png"));
                Thread.sleep(70);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame005.png"));
                Thread.sleep(70);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame006.png"));
                Thread.sleep(70);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame007.png"));
                Thread.sleep(70);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame008.png"));
                Thread.sleep(70);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame009.png"));
                Thread.sleep(70);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame010.png"));
                monsterSlain();
                Thread.sleep(70);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame011.png"));
                Thread.sleep(70);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame012.png"));
                Thread.sleep(70);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame013.png"));
                Thread.sleep(70);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame014.png"));
                Thread.sleep(70);
                playerattackend.setOpacity(70);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame015.png"));
                Thread.sleep(70);
                playerattackend.setOpacity(40);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame016.png"));
                Thread.sleep(70);
                playerattackend.setOpacity(0);
                playerattackend.setImage(new Image("src/sample/Player Battler/Battle End/Frame017.png"));
                Thread.sleep(70);

                displayPlayer.setOpacity(30);
                displayPlayer.setImage(new Image("src/sample/Player Battler/Jump Back/Frame001.png"));
                Thread.sleep(70);
                displayPlayer.setOpacity(30);
                displayPlayer.setImage(new Image("src/sample/Player Battler/Jump Back/Frame002.png"));
                Thread.sleep(70);
                displayPlayer.setOpacity(30);
                displayPlayer.setImage(new Image("src/sample/Player Battler/Jump Back/Frame003.png"));
                Thread.sleep(70);
                displayPlayer.setOpacity(30);
                displayPlayer.setImage(new Image("src/sample/Player Battler/Jump Back/Frame004.png"));
                Thread.sleep(70);

                whichmonster = 0;

                idleposestart();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
