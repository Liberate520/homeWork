package ru.gb.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Branch implements Serializable {
    Person focusPerson;
    List<Person> branchOfParent;
    List<Person> branchOfChild;

    public Branch(){
        this.branchOfParent = new ArrayList<Person>();
        this.branchOfChild = new ArrayList<Person>();
    }

    public void addBranch(Person focusPerson, boolean parent, boolean child) {

        this.focusPerson = focusPerson;

        if(parent) {
            System.out.println("\n Родитель:");
            Person par = new Person();
            boolean sign = branchOfParent.add(par.addPerson());
        }
        if(child) {
            System.out.println("\n Ребёнок:");
            Person chil = new Person();
            boolean sign = branchOfChild.add(chil.addPerson());
        }

    }
}
