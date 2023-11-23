package model.human;
import model.fmilyTree.ItemOfFamilyTree;
import model.service.Saver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human extends Saver implements Comparable, ItemOfFamilyTree {
    private int id;
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
        this(name, bd, gender, null, null);
    }
    public Human(int id, Human human) {
        this(human.name, human.bd, human.gender);
        this.id = id;
    }

    public Human(int id, String name, LocalDate bd, Gender gender) {
        this(name, bd, gender);
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public int getAge() {return LocalDate.now().getYear() - bd.getYear();};

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
        if (!mother.children.contains(this)) {
            mother.setChildren(this);
        }
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
        if (!father.children.contains(this)) {
            father.setChildren(this);
        }
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human children: children) {
            stringBuilder.append(children.name + ", ");
        }
        return stringBuilder.toString();
    }

    public void setChildren(Human human) {
        if (!this.children.contains(human)) {
            this.children.add(human);
        }
        if (this.gender == Gender.male) {
            human.setFather(this);
        } else {
            human.setMother(this);
        }
    }

    @Override
    public String toString() {
        return this.id +
                ", " + this.name +
                ", " + this.bd +
                ". ";
    }

    public String humanInfo() {
            return this.name +
                    ", " + this.bd +
                    ", Mother: " + this.mother +
                    ", Father: " + this.father +
                    ", children: " + this.getChildren() +
                    " ";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}




