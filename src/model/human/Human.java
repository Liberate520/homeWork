package model.human;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;



 
public class Human implements Serializable, Comparable<Human> {
   private int id;
   private String fulName;
   private Gender gender;
   private Human mother;
   private Human father;
   private List<Human> children;
   private int birthDate;
   private int deathDate;
   private Human spouse;

   public Human(int id, String fulName, int birthDate, int deathDate, Gender gender, Human mother, Human father) {
        this.id = id;
        this.fulName = fulName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        
        this.children = new ArrayList<>();
    }

    public Human(int id, String fulName, int birthDate, Gender gender, Human mother, Human father) {
       this.id = id;
       this.fulName = fulName;
       this.gender = gender;
       this.father = null;
       this.mother = null;
       this.birthDate = birthDate;
       this.children = new ArrayList<>();
    }

        

    public boolean addChild(Human child) {
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    
    
   
    public Human getFather() {
       return father;       
    }   
    
    public Human getMother() {
        return mother;
    }

    public String getFulName(){
        return fulName;
    }

    

    

       

    public void setSpouse(Human spouse){
        this.spouse = spouse;
    }

    public Human getSpouse(){
        return spouse;
    }

    @Override
    public String toString() {
        return String.format("id:%d; полное имя: %s; год рождения: %d; \n", this.id, this.fulName, this.birthDate );
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

        
    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }


    

    public void setMother(Human mother) {
        this.mother = mother;
    }

    
    public void setFather(Human father) {
        this.father = father;
    }

    public Gender getGender() {
        return gender;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public int getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(int deathDate) {
        this.deathDate = deathDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int compareTo(Human o){
        return fulName.compareTo(o.getFulName());
    }
}
    





