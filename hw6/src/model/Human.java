package model;

import java.util.ArrayList;
import java.util.List;

public class Human{
    int id;
    String name;
    int age;
    List<Relation> relation;

    public Human(List<Human> list, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Human(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Relation> getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        if(this.relation == null){
            ArrayList<Relation> temp = new ArrayList<>();
            temp.add(relation);
            this.relation = temp;
        } else {
            this.relation.add(relation);
        }
    }

    public String printHuman(Human human){
        StringBuilder result = new StringBuilder();
        result = new StringBuilder("id human: " + human.id + "\n" + "name human: " + human.name +
                "\n" + "age human: " + human.age + "\n" + "relation human: " + "\n");
        if (human.relation != null){
            for(Relation r : human.relation){
                result.append("for human ").append(r.getRelationHuman()).append(" relation - ").
                        append(r.getRelation()).append("\n");
            }
        }
        return result.toString();
    }

    public String printChildren(Human human){
        StringBuilder result = new StringBuilder();
        if(human.relation != null){
            for (Relation r : human.relation) {
                if(r.getRelationId() == 2){
                    result.append("Child for parent id ").append(r.getRelationHuman());
                }
            }
        }
        return result.toString();
    }
}
