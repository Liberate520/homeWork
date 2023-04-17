package model.Persons;

import java.io.Serializable;

public class Others extends Person implements Serializable, InterfaceOthers

{
    private int id;
    private String Name;
    private String Occupation;

    public Others(int id, String Name, String Occupation)
    {
        this.id = id;
        this.Name = Name;
        this.Occupation = Occupation;  
    }    

    public Others(int id, String Name)
    {
        this(id, Name, null);    
    }

    public Others(int id)
    {
        this(id, null, null);     
    }

    public Others()
    {
        this(0,  null, null);
    }
    
    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return Name;
    }

    public String getOccupation() 
    {
        return Occupation;
    }
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(id).append(", имя: ").append(Name).append("\n").append("   должность:  ").append(Occupation).append("\n");
        return sb.toString();
    }

}


