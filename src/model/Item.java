package model;

import java.util.List;

public interface Item {

    public int getId();

    public String getName();
    public void setName(String name);

    public int getAge();
    public void setAge(int age);
    
    public List<Relationship> getRelationships();
    public void setRelationship(Relationship relationship);

    public String itemToString();

    public String childrensToString();

    
}
