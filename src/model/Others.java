package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
public class Others<T extends Node> implements Serializable, Node<T>

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
    
    


   
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public String getOccupation() {
        return Occupation;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(id).append(", имя: ").append(Name).append("\n").append("   должность:  ").append(Occupation).append("\n");

        return sb.toString();
    }

    @Override
    public String getLastName() {
        throw new UnsupportedOperationException("Unimplemented method 'getLastName'");
    }

    @Override
    public String getFirstName() {
        throw new UnsupportedOperationException("Unimplemented method 'getFirstName'");
    }

    @Override
    public Gender getGender() {
        throw new UnsupportedOperationException("Unimplemented method 'getGender'");
    }

    @Override
    public LocalDate getDataBirth() {
        throw new UnsupportedOperationException("Unimplemented method 'getBirthDate'");
    }

    @Override
    public LocalDate getDataDeath() {
        throw new UnsupportedOperationException("Unimplemented method 'getDeathDate'");
    }

    @Override
    public T getFather() {
        throw new UnsupportedOperationException("Unimplemented method 'getFather'");
    }

    @Override
    public T getMother() {
        throw new UnsupportedOperationException("Unimplemented method 'getMother'");
    }

    @Override
    public T getChildren() {
        throw new UnsupportedOperationException("Unimplemented method 'getChildren'");
    }

    public void addPerson(Others value) {
    }
}


