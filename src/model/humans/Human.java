package model.humans;

import model.famalyTree.FamilyTreeItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyTreeItems {

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

    public Human(Gender gender, String firstName, String lastName) {
        this(gender, firstName, lastName, null, null);
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
        StringBuilder sb = new StringBuilder();
        String motherName;
        String fatherName;
        String partnerName;
        if(partner == null) {partnerName = "неизвестно";}
        else {partnerName = partner.getFirstName();}
        if(mother == null) {motherName = "неизвестно";}
        else {motherName = mother.getFirstName();}
        if(father == null) {fatherName = "неизвестно";}
        else {fatherName = father.getFirstName();}
        sb.append("Гендер: ");
        sb.append(gender);
        sb.append(", Партнер: ");
        sb.append(partnerName);
        sb.append(", Имя: ");
        sb.append(firstName);
        sb.append(", Фамилия: ");
        sb.append(lastName);
        sb.append(", Мать: ");
        sb.append(motherName);
        sb.append(", Отец: ");
        sb.append(fatherName);
        sb.append(", Дети: ");
        sb.append(this.getChildrenName());
        return sb.toString();
    }

    public String getChildrenName(){
        StringBuilder sb = new StringBuilder();
        if(children.size() == 0) {
            sb.append("нет детей");
        } else {
            for (Human human : children) {
                sb.append(human.getFirstName());
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}