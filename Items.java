package src.sample;

import java.io.Serializable;

public class Items implements Serializable
{
    int id, exp;
    String name, desc;

    public Items(int i, String n, int e, String d)
    {
        id = i; exp = e; name = n; desc = d;
    }

    public int getId()
    {
        return id;
    }

    public int getExp()
    {
        return exp;
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