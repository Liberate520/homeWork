package ru.gb.fam_tree.human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String firstName, lastName;
    private Genger genger;
    private Human mother, father, spouse;
    private List<Human> childrens;


    public Human(String firstName, String lastName,Genger genger, Human mother, Human father, Human spouse, List<Human> childrens) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        this.childrens = childrens;
        this.genger = genger;
    }

    public Human(String firstName, String lastName, Genger genger, Human mother, Human father) {
        this(firstName,lastName,genger,mother,father,null,null);
    }

    public Human(String firstName, String lastName, Genger genger) {
        this(firstName,lastName,genger,null,null,null,null);
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public void setChildrens(List<Human> childrens) {
        this.childrens = childrens;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<String> getChildrensNames(Human parentHuman){
        List<String> res = new ArrayList<>();
        StringBuilder names = new StringBuilder();
        for(Human i: parentHuman.getChildrens()) {
            res.add(i.getFirstName());
        }
        return res;
    }
}



