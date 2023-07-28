package ru.gb.fam_tree.human;

import javax.print.attribute.standard.JobHoldUntil;
import java.util.List;

public class Human {
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
        this.firstName = firstName;
        this.lastName = lastName;
        this.genger = genger;
        this.mother = mother;
        this.father = father;
    }

    public Human(String firstName, String lastName, Genger genger, Human spouse, List<Human> childrens) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.genger = genger;
        this.spouse = spouse;
        this.childrens = childrens;
    }

    public Human(String firstName, String lastName, Genger genger) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.genger = genger;
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

    public void printRelativesList(Human human){
        StringBuilder result = new StringBuilder();
        int temp = 0;
        for(Human i : father.getChildrens()) {
            if(!(i.getFirstName().equals(human.getFirstName()))){
                if(temp == 0){
                    result.append(i.getFirstName());
                    temp++;
                }
                else {
                    result.append(", "+ i.getFirstName());
                }
            }
        }
        String res = String.format("%s's sister(s) and/or brother(s): %s", human.getFirstName(), result);
        System.out.println(res);
    }
}



