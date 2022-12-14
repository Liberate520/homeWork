package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Human implements Item {
    
    private int id;
    private String name;
    private int age;
    private List<Relationship> relationships;

    public Human(List<Item> list, String name, int age) {
        this.id = setId(list);
        this.name = name;
        this.age = age;
    }

    public Human() {
    }

    @Override
    public int getId() {
        return id;
    }

    private int setId(List<Item> list) {
        int upperRange = 1000;
        Random random = new Random();
        int tempId = random.nextInt(upperRange);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == tempId){
                tempId++;
                i = 0;
            }
        }
        return this.id = tempId;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }
    
    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public List<Relationship> getRelationships() {
        return relationships;
    }
    
    @Override
    public void setRelationship(Relationship relationship) {
        
        if (this.relationships == null){
            ArrayList<Relationship> temp = new ArrayList<Relationship>();
            temp.add(relationship);
            this.relationships = temp;
        }
        else{
            this.relationships.add(relationship);
        }
    }
    
    @Override
    public String itemToString(){
        String res = "";
        res = "id человека: " + this.id + "\n" + "имя человека: " + this.name + "\n" + 
        "Возраст человека: " + this.age +"\n" + "Связи человека: " + "\n";
        if (this.relationships != null){
            for (Relationship r : this.relationships){
                    res = res + "с человеком " + r.getRelationToHumanId() +
                    " существует связь - " + r.getRelation() + "\n";
                }
        }            
        return res; 
    }
    
    @Override
    public String childrensToString(){
        String res = "";
        if (this.relationships != null){
            for (Relationship r : this.relationships){
                if (r.getRelationId() == 2){ //2 - 'это связь дети в Relationships'
                    res = res + "Id ребенка " + r.getRelationToHumanId();
                }    
            }
        }
        return res;
    }
}

