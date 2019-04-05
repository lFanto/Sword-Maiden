package src.sample;

import java.io.Serializable;

public class Monster implements Serializable
{
    int id, damage, health, exp, gold, kTI;
    String name, desc;

    public Monster(int i, String n, int h, int d, int e, int g, int k, String dc)
    {
        id = i; name = n; damage = d; health = h; exp = e; gold = g; kTI = k; desc = dc;
    }

    public int getID()
    {
        return id;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getHealth()
    {
        return health;
    }

    public int getExp()
    {
        return exp;
    }

    public int getGold()
    {
        return gold;
    }

    public int getkTI()
    {
        return kTI;
    }

    public String getName()
    {
        return name;
    }

    public String getDesc()
    {
        return desc;
    }

}