package src.sample;

import java.sql.*;
import java.util.ArrayList;
import java.io.*;

public class SConnect extends Game implements Serializable {
    protected Connection swmaiden;
    private ResultSet rs, rs2, rs3;
    private Monster monster;
    private Items item;

    protected static ArrayList<Player> players = new ArrayList<>(10);
    protected static ArrayList<Monster> monsterlist = new ArrayList<>(10);
    protected static ArrayList<Items> itemlist = new ArrayList<>(10);


    public SConnect()
    {
        try {
            // 1. Get a connection to database
            swmaiden = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/SwordMaiden", "postgres", "19003586");

            System.out.println("Connected Successfully") ;

            //Pull monster data from postgresql database

            String query = "SELECT * FROM \"Bestiary\"";
            rs = swmaiden.createStatement().executeQuery(query);
            while(rs.next()){
                monster = new Monster(rs.getInt("Monster ID"),
                        rs.getString("Name").trim(),
                        rs.getInt("Health Value"),
                        rs.getInt("Damage Value"),
                        rs.getInt("Experience Value"),
                        rs.getInt("Gold Value"),
                        rs.getInt("KeyToItem"),
                        rs.getString("Description").trim());
                monsterlist.add(monster);
            }

            String query2 = "SELECT * FROM \"Item Database\"";
            rs2 = swmaiden.createStatement().executeQuery(query2);
            while(rs2.next()) {
                item = new Items(rs2.getInt("Item ID"),
                        rs2.getString("Item Name").trim(),
                        rs2.getInt("Experience Value"),
                        rs2.getString("Description").trim());
                itemlist.add(item);
            }

            String query3 = "SELECT * FROM \"Player\"";
            rs3 = swmaiden.createStatement().executeQuery(query3);
            while(rs3.next())
            {
                Player p = new Player(rs3.getInt("ID"),
                        rs3.getString("Name").trim(),
                        rs3.getInt("Level Value"),
                        rs3.getInt("Health Value"),
                        rs3.getInt("Damage Value"),
                        rs3.getInt("Experience Value"),
                        rs3.getInt("KeyToUserPet"),
                        rs3.getString("Description").trim(),
                        rs3.getInt("Stamina Value"));
                players.add(p);
            }
            //Serialize the monster and item info into a file
            try {
                ObjectOutputStream writetoMFile = new ObjectOutputStream(new FileOutputStream(new File("SM Monster.lin")));
                ObjectOutputStream writetoIFile = new ObjectOutputStream(new FileOutputStream(new File("SM Item.lin")));
                for (Monster m : monsterlist){
                    writetoMFile.writeObject(m);
                }
                for (Items i : itemlist)
                {
                    writetoIFile.writeObject(i);
                }
            }catch(FileNotFoundException e) {
                e.getMessage();
            }
        }

        catch(Exception e)
        {
            System.out.println("Could not connect");
            e.printStackTrace();
        }
    }

    public ArrayList<Monster> getMonsterlist()
    {
        return monsterlist;
    }

    public ArrayList<Items> getItemlist()
    {
        return itemlist;
    }

    public ArrayList<Player> getPlayerlist()
    {
        return players;
    }
}