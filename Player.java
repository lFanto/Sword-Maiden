package src.sample;

import java.io.Serializable;

public class Player implements Serializable
{
    int id, level, health, damage, exp, kTUP, stamina;
    String name, desc;

    public Player(int i, String n, int l, int h, int d, int e, int k, String ds, int s)
    {
        id = i; name = n; level = l; health = h; damage = d; exp = e; kTUP = k; desc = ds; stamina = s;
    }

    public int getId()
    {
        return id;
    }

    public int getLevel()
    {
        return level;
    }

    public int getHealth()
    {
        return health;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getExp()
    {
        return exp;
    }

    public int getkTUP()
    {
        return kTUP;
    }

    public String getName()
    {
        return name;
    }

    public String getDesc()
    {
        return desc;
    }

    public int getStamina()
    {
        return stamina;
    }
}