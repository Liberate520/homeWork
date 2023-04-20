package FamalyTree;

import SaveAs.TextFormat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {

    private Gender gender;
    private Human partner;
    private String firstName;
    private String lastName;
    private Human mother;
    private Human father;
    private List<Human> children;


    public Human(Gender gender, String firstName, String lastName, Human mother, Human father) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mother = mother;
        this.father = father;
        children = new ArrayList();
        partner = null;
    }

    public Human(Gender gender, String firstName) {
        this(gender, firstName, null, null, null);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setPartner(Human partner) {
        this.partner = partner;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human getPartner() {
        return partner;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild (Human child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Human human) {
            return (firstName + lastName).equals(human.getFirstName() + human.getLastName());
        }
        return false;
    }

    public void saveAs(String path, TextFormat format) {
        format.SaveAs(this, path);
    }

}
