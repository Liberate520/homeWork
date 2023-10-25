package FT;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate bd;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, LocalDate bd, Gender gender, Human mother, Human father) {
        children = new ArrayList<>();
        this.name = name;
        this.bd = bd;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, LocalDate bd, Gender gender){
        children = new ArrayList<>();
        this.name = name;
        this.bd = bd;
        this.gender = gender;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public LocalDate getBd() {
        return bd;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human children: children) {
            stringBuilder.append(children.name + ", ");
        }
        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
        return stringBuilder.toString();
    }

    public void setChildren(Human human) {
        this.children.add(human);
        if (this.gender == Gender.male) {
            human.setFather(this);
        }
        human.setMother(this);
    }

    @Override
    public String toString() {
        return "Name: " + this.name +
                ", bd: " + this.bd +
                ". ";
    }

    public String humanInfo() {
        return  "Name: " + this.name +
                    ", bd: " + this.bd +
                    ", Mother: " + this.mother +
                    ", Father: " + this.father +
                    ", children: " + this.getChildren() +
                    ". ";
    }
}




