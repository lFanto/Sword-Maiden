package src.sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.Random;

public class Battle_v2 extends Overworld implements Runnable
{
    public Text hpField, statusField, displayMHP, displayMHP2, displayMHP3, battleText;
    public Thread damageThread, deathThread;
    //Monster class
    Monster enemy, enemy2, enemy3;
    //Monsterfields
    public ImageView monsterField1;
    public ImageView monsterField2;
    public ImageView monsterField3;
    //Attack Monster Images
    public ImageView attackMonster1;
    public ImageView attackMonster2;
    public ImageView attackMonster3;
    //Images for the monsters
    private Image slime = new Image("src/sample/Enemy Battlers/slime001_v2.png");
    private Image bat = new Image("src/sample/Enemy Battlers/beetle_03.png");
    private Image bee = new Image("src/sample/Enemy Battlers/bee001_v2.png");
    //Monster stat fields
    private int monsterHealth, monsterDamage, monsterEXP, monsterGold, monsterHealth2, monsterDamage2, monsterEXP2, monsterGold2;
    private int monsterHealth3, monsterDamage3, monsterEXP3, monsterGold3;
    //Did the mmonster appear?
    boolean firstMonAppeared, secondMonAppeared, thirdMonAppeared;
    //Which monster was attacked?
    boolean firstmon = false;
    boolean secondmon = false;
    boolean thirdmon = false;
    //Which monster died?
    boolean firstMonDeath = false;
    boolean secondMonDeath = false;
    boolean thirdMonDeath = false;
    //Random number for hit
    Random rand = new Random();

    //Show Damage in Pictures
    ImageView numberOne, numberTwo, numberThree;
    int event;
    public Battle_v2()
    {

    }

    public void initialize()
    {
        firstMonAppeared = false;
        secondMonAppeared = false;
        thirdMonAppeared = false;
        encounter();
        hpField.setText(""+playerMHealth+"/"+playerCHealth);
        statusField.setText("Status : Normal");
    }

    public void attackMonster1()
    {
        firstmon = true;
        damageThread = new Thread(this);
        damageThread.start();
    }

    public void attackMonsterEnd1()
    {
        event = rand.nextInt(101);
        calculateDamage(event);
    }

    public void attackMonster2()
    {
        if(secondMonAppeared) {
            secondmon = true;
            damageThread = new Thread(this);
            damageThread.start();
        }
    }

    public void attackMonsterEnd2()
    {
        if(secondMonAppeared) {
            event = rand.nextInt(101);
            calculateDamage(event);
        }
    }

    public void attackMonster3()
    {
        if(thirdMonAppeared) {
            thirdmon = true;
            damageThread = new Thread(this);
            damageThread.start();
        }
    }

    public void attackMonsterEnd3()
    {
        if(thirdMonAppeared) {
            event = rand.nextInt(101);
            calculateDamage(event);
        }
    }
    @Override
    public void run()
    {
            try {
                if(firstmon) {
                    attackMonster1.setOpacity(100);
                    attackMonster1.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame001.png"));
                    Thread.sleep(playerASPD);
                    attackMonster1.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame002.png"));
                    Thread.sleep(playerASPD);
                    attackMonster1.setOpacity(90);
                    attackMonster1.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame003.png"));
                    Thread.sleep(playerASPD);
                    attackMonster1.setOpacity(75);
                    attackMonster1.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame004.png"));
                    Thread.sleep(playerASPD);
                    attackMonster1.setOpacity(30);
                    attackMonster1.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame005.png"));
                    Thread.sleep(playerASPD);
                    attackMonster1.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame006.png"));
                    Thread.sleep(playerASPD);
                    attackMonster1.setOpacity(0);
                    attackMonster1.setImage(null);
                }
                if(secondmon) {
                    attackMonster2.setOpacity(100);
                    attackMonster2.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame001.png"));
                    Thread.sleep(playerASPD);
                    attackMonster2.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame002.png"));
                    Thread.sleep(playerASPD);
                    attackMonster2.setOpacity(90);
                    attackMonster2.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame003.png"));
                    Thread.sleep(playerASPD);
                    attackMonster2.setOpacity(75);
                    attackMonster2.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame004.png"));
                    Thread.sleep(playerASPD);
                    attackMonster2.setOpacity(30);
                    attackMonster2.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame005.png"));
                    Thread.sleep(playerASPD);
                    attackMonster2.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame006.png"));
                    Thread.sleep(playerASPD);
                    attackMonster2.setOpacity(0);
                    attackMonster2.setImage(null);
                }

                if(thirdmon) {
                    attackMonster3.setOpacity(100);
                    attackMonster3.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame001.png"));
                    Thread.sleep(playerASPD);
                    attackMonster3.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame002.png"));
                    Thread.sleep(playerASPD);
                    attackMonster3.setOpacity(90);
                    attackMonster3.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame003.png"));
                    Thread.sleep(playerASPD);
                    attackMonster3.setOpacity(75);
                    attackMonster3.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame004.png"));
                    Thread.sleep(playerASPD);
                    attackMonster3.setOpacity(30);
                    attackMonster3.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame005.png"));
                    Thread.sleep(playerASPD);
                    attackMonster3.setImage(new Image("src/sample/Player Battler/Sword Attack 1/Frame006.png"));
                    Thread.sleep(playerASPD);
                    attackMonster3.setOpacity(0);
                    attackMonster3.setImage(null);
                }

            } catch (Exception e) {
                e.getMessage();
        }
    }

    public void calculateDamage(int genNumber)
    {
        if(firstmon == true) {
            if(randomEvent(genNumber, 19, 0))//Miss Chance
            {
                battleText.setText("You missed "+enemy.getName()+"!!!");
                firstmon = false;
            }else if (randomEvent(genNumber, 89, 20)) //Hit Chance
            {
                monsterHealth = monsterHealth - playerDamage;
                //showDamage(playerDamage);
                displayMHP.setText("" + monsterHealth);
                if (monsterHealth > 0) {
                    battleText.setText("You dealt " + playerDamage + " damage on " + enemy.getName() + "!!");
                    firstmon = false;
                }
                else {
                    battleText.setText("You dealt " + playerDamage + " damage on " + enemy.getName() + "!!" + "\nYou have defeated a " + enemy.getName() + "!!\n");
                    modifyPlayer();
                }
            }else if(randomEvent(genNumber, 100, 90)) //Critical Chance
            {
                monsterHealth = monsterHealth - (playerDamage*2);
               // showDamage(playerDamage*2);
                displayMHP.setText("" + monsterHealth);
                if (monsterHealth > 0){
                    battleText.setText("You swung hard and dealt " + (playerDamage*2) + " damage on " + enemy.getName() + "!!!!!");
                    firstmon = false;
                }
                else {
                    battleText.setText("You swung hard and dealt " + (playerDamage*2) + " damage on " + enemy.getName() + "!!" + "\nYou have defeated a " + enemy.getName() + "!!\n");
                    modifyPlayer();
                }
            }
        }

        if(secondmon == true)
            if(randomEvent(genNumber, 19, 0))//Miss Chance
            {
                battleText.setText("You missed "+enemy2.getName()+"!!!!");
                secondmon = false;
            }else if (randomEvent(genNumber, 89, 20)) //Hit Chance
            {
                monsterHealth2 = monsterHealth2 - playerDamage;
                displayMHP2.setText("" + monsterHealth2);
                if (monsterHealth2 > 0) {
                    battleText.setText("You dealt " + playerDamage + " damage on " + enemy2.getName() + "!!");
                    secondmon = false;
                }
                else {
                    battleText.setText("You dealt " + playerDamage + " damage on " + enemy2.getName() + "!!" + "\nYou have defeated a " + enemy2.getName() + "!!\n");
                    modifyPlayer();
                    secondmon = false;
                }
            }else if(randomEvent(genNumber, 100, 90)) //Critical Chance
            {
                monsterHealth2 = monsterHealth2 - (playerDamage*2);
                displayMHP2.setText("" + monsterHealth2);
                if (monsterHealth2 > 0) {
                    battleText.setText("You swung hard and dealt " + (playerDamage * 2) + " damage on " + enemy2.getName() + "!!!!!");
                    secondmon = false;
                }
                else {
                    battleText.setText("You swung hard and dealt " + (playerDamage*2) + " damage on " + enemy2.getName() + "!!" + "\nYou have defeated a " + enemy2.getName() + "!!\n");
                    modifyPlayer();
                    secondmon = false;
                }
            }

        if(thirdmon == true)
            if(randomEvent(genNumber, 19, 0))//Miss Chance
            {
                battleText.setText("You missed "+enemy3.getName()+"!!!!");
                thirdmon = false;
            }else if (randomEvent(genNumber, 89, 20)) //Hit Chance
            {
                monsterHealth3 = monsterHealth3 - playerDamage;
                displayMHP3.setText("" + monsterHealth3);
                if (monsterHealth3 > 0) {
                    battleText.setText("You dealt " + playerDamage + " damage on " + enemy3.getName() + "!!");
                    thirdmon = false;
                }
                else {
                    battleText.setText("You dealt " + playerDamage + " damage on " + enemy3.getName() + "!!" + "\nYou have defeated a " + enemy3.getName() + "!!\n");
                    modifyPlayer();
                    thirdmon = false;
                }
            }else if(randomEvent(genNumber, 100, 90)) //Critical Chance
            {
                monsterHealth3 = monsterHealth3 - (playerDamage*2);
                displayMHP3.setText("" + monsterHealth3);
                if (monsterHealth3 > 0) {
                    battleText.setText("You swung hard and dealt " + (playerDamage * 2) + " damage on " + enemy3.getName() + "!!!!!");
                    thirdmon = false;
                }
                else {
                    battleText.setText("You swung hard and dealt " + (playerDamage*2) + " damage on " + enemy3.getName() + "!!" + "\nYou have defeated a " + enemy3.getName() + "!!\n");
                    modifyPlayer();
                    thirdmon = false;
                }
            }
        }

    public void modifyPlayer()
    {
        int itemdroprate = rand.nextInt(100);
        if(firstmon) {
            firstmon = false;
            firstMonDeath = true;
            switch(enemy.getID()){
                case 1: if(randomEvent(itemdroprate, 25, 0))
                {

                }
                case 2: if(randomEvent(itemdroprate, 25, 0));
                {

                }
                case 3: if(randomEvent(itemdroprate, 25, 0))
                {

                }
            }

            currentGold = currentGold + enemy.getGold();
            playerEXP = playerEXP - enemy.getExp();

            battleText.setText("" + "You gained " + enemy.getGold() + "Gold and " + enemy.getExp() + " Experience!\n" +
                    playerEXP + " experience left until next level up.");
        }
    }
    public void encounter()
    {
        if(!(firstMonAppeared)) {
            firstMonAppeared = true;
            Random rand = new Random();
            int index = rand.nextInt(monsterlist.size());
            enemy = monsterlist.get(index);
            setMonster(enemy);
        }
        if(!(secondMonAppeared))
        {
            if(randomEvent(rand.nextInt(30), 20,0))
            {
                secondMonAppeared = true;
                int index = rand.nextInt(monsterlist.size());
                enemy2 = monsterlist.get(index);
                setMonster(enemy2);
            }
        }

        //Second monster must appear in order for third monster to appear
        if(secondMonAppeared)
        if(!(thirdMonAppeared))
        {
            if(randomEvent(rand.nextInt(30), 10,0))
            {
                thirdMonAppeared = true;
                int index = rand.nextInt(monsterlist.size());
                enemy3 = monsterlist.get(index);
                setMonster(enemy3);
            }
        }
    }

    public Monster setMonster(Monster m)
    {
        if(firstMonAppeared == true) {
            switch (m.getID()) {
                case 1:
                    monsterField1.setImage(slime);
                    initializeMonster(m.getID());
                    break;
                case 2:
                    monsterField1.setImage(bat);
                    initializeMonster(m.getID());
                    break;
                case 3:
                    monsterField1.setImage(bee);
                    initializeMonster(m.getID());
                    break;
                default:
                    System.out.println("No monster??");
            }
        }
        if (secondMonAppeared == true)
        {
            switch (m.getID()) {
                case 1:
                    monsterField2.setImage(slime);
                    initializeMonster(m.getID());
                    break;
                case 2:
                    monsterField2.setImage(bat);
                    initializeMonster(m.getID());
                    break;
                case 3:
                    monsterField2.setImage(bee);
                    initializeMonster(m.getID());
                    break;
                default:
                    System.out.println("No monster??");
            }
        }
        if (thirdMonAppeared == true)
        {
            switch (m.getID()) {
                case 1:
                    monsterField3.setImage(slime);
                    initializeMonster(m.getID());
                    break;
                case 2:
                    monsterField3.setImage(bat);
                    initializeMonster(m.getID());
                    break;
                case 3:
                    monsterField3.setImage(bee);
                    initializeMonster(m.getID());
                    break;
                default:
                    System.out.println("No monster??");
            }
        }
        return m;
    }

    public void initializeMonster(int id)
    {
        if(firstMonAppeared == true) {
            monsterHealth = enemy.getHealth();
            monsterDamage = enemy.getDamage();
            monsterEXP = enemy.getExp();
            monsterGold = enemy.getGold();

            displayMHP.setText("" + monsterHealth);
            battleText.setText("A " + enemy.getName() + " has appeared!!!");
            firstMonAppeared = false;
        }
        if(secondMonAppeared == true)
        {
            monsterHealth2 = enemy2.getHealth();
            monsterDamage2 = enemy2.getDamage();
            monsterEXP2 = enemy2.getExp();
            monsterGold2 = enemy2.getGold();

            displayMHP2.setText("" + monsterHealth2);
            battleText.setText("A " + enemy2.getName() + " has appeared!!!");
        }
        if(thirdMonAppeared == true)
        {
            monsterHealth3 = enemy3.getHealth();
            monsterDamage3 = enemy3.getDamage();
            monsterEXP3 = enemy3.getExp();
            monsterGold3 = enemy3.getGold();

            displayMHP3.setText("" + monsterHealth3);
            battleText.setText("A " + enemy3.getName() + " has appeared!!!");
        }
    }

    public boolean randomEvent(int num, int high, int low)
    {
        return ((high >= num) && (num >= low));
    }

    public void showDamage(int damage)
    {
        if(firstmon)
        {
            if(damage < 10) {
                switch(damage) {
                    case 1: numberOne.setImage(new Image("src/sample/Stage/Numbers/Normal One.png"));
                            break;
                    case 2: numberOne.setImage(new Image("src/sample/Stage/Numbers/Normal Two.png"));
                            break;
                    case 3: numberOne.setImage(new Image("src/sample/Stage/Numbers/Normal Three.png"));
                        break;
                    case 4: numberOne.setImage(new Image("src/sample/Stage/Numbers/Normal Four.png"));
                        break;
                    case 5: numberOne.setImage(new Image("src/sample/Stage/Numbers/Normal Five.png"));
                        break;
                    case 6: numberOne.setImage(new Image("src/sample/Stage/Numbers/Normal Six.png"));
                        break;
                    case 7: numberOne.setImage(new Image("src/sample/Stage/Numbers/Normal Seven.png"));
                        break;
                    case 8: numberOne.setImage(new Image("src/sample/Stage/Numbers/Normal Eight.png"));
                        break;
                    case 9: numberOne.setImage(new Image("src/sample/Stage/Numbers/Normal Nine.png"));
                        break;
                    case 0: numberOne.setImage(new Image("src/sample/Stage/Numbers/Normal Zero.png"));
                        break;

                }
            }
        }
    }
}