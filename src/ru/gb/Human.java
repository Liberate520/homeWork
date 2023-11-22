package ru.gb;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Human implements Serializable {

    private long id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human parent1, parent2;
    private Gender gender;
    private List<Human> children;



    public Human(String name, LocalDate birthDate,
                 LocalDate deathDate, Human parent1,
                 Human parent2, Gender gender, List<Human> children) {
        id = -1;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.gender = gender;
        this.children = (children !=null) ? children :new ArrayList<>();

        if (parent1!=null){
            parent1.addChild(this);
        }
        if (parent2!=null){
            parent2.addChild(this);
        }
    }
    public String getName(){return name;}
    public LocalDate getBirthDate(){return birthDate;}
    public LocalDate getDeathDate(){return deathDate;}

    public void setBirthDate(LocalDate birthDate){this.birthDate=birthDate;}
    public void setDeathDate(LocalDate deathDate){this.deathDate=deathDate;}

    public long getId(){return id;}

    public void setId(long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }
    public  boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public void addParent (Human parent){
        setParent1(parent);
        setParent2(parent);
    }

    public void setParent1(Human parent) {
        this.parent1 = parent;
    }

    public void setParent2(Human parent) {
        this.parent2 = parent;
    }
    public Human getParent1(){return parent1;}
    public Human getParent2(){return parent2;}
    public  List<Human>getParents(){
        List<Human> list = new ArrayList<>(2);
        if (parent1 != null){
            list.add(parent1);
        }
        if (parent2 != null){
            list.add(parent2);
        }
        return list;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return  true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId()==getId();
    }

    @Override
    public String toString() {
        StringBuilder childrenNames = new StringBuilder();
        for (Human child : children) {
            if (childrenNames.length() > 0) {
                childrenNames.append(", ");
            }
            childrenNames.append(child.getName());
        }
        return
                "id: " + id +
                ", ФИО: " + name +
                ", Дата рождения: " + birthDate +
                ", Дата смерти: " + (deathDate !=null ? deathDate.toString(): "Нет") +
                ", Родитель 1: " + (parent1 != null ? parent1.getName() : "Нет") +
                ", Родитель 2: " + (parent2 != null ? parent2.getName() : "Нет") +
                ", Пол: " + (gender==Gender.Male? "Мужской": "Женский") +
                ", Дети: " + (childrenNames.isEmpty() ? "Нет":childrenNames) + ".";

    }
}
