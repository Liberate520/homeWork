package Humans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, Comparable {
    private String name;
    private String surname;
    private Date dateOfBirth = new Date();
    private Date dateOfDeath = new Date();
    private Human mother;
    private Human father;
    private String gender;
    private List<Human> children = new ArrayList<Human>();

    public Human(String name, String surname,
                 Date dateOfBirth, Date dateOfDead, Human mother,
                 Human father,String gender, List children){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDead;
        this.mother = mother;
        this.father = father;
        this.gender = gender;
        this.children = children;
    }
    public Human (String name, String surname, String gender){
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public void setMother(Human human){
        this.mother = human;
        human.addChildren(this);

    }
    public void setFather(Human human){
        if(father==null || !father.equals(human)){
            this.father = human;
            human.addChildren(this);
        }

    }
    public void addChildren(Human human){
        if(!children.contains(human)){
            this.children.add(human);
            if (gender.equals("female")){
                human.setMother(this);
            }
            if (gender.equals("male")){
                human.setFather(this);
            }
        }


    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public String getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Humans.Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return name.equals(human.name) && surname.equals(human.surname) && dateOfBirth.equals(human.dateOfBirth) && gender.equals(human.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, dateOfBirth, gender);
    }

    @Override
    public int compareTo(Object o) {
        Human x = (Human) o;
        return this.surname.compareTo(x.surname);
    }
}
