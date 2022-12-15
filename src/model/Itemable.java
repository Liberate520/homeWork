package model;


import java.util.List;

public interface Itemable {
    int getId();
    String getName();
    void setName(String name);
    int getAge();
    void setAge(int age);
    List<Relation> getRelations();
    void setRelationship(Relation relationship);
    String itemToString();
    String childrensToString();
}
