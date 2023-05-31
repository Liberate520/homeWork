package java_oop_homeWork.src.model.person;

import java_oop_homeWork.src.model.Sex;
import java_oop_homeWork.src.model.FamilyTree;
import java_oop_homeWork.src.model.display.DisplayInfo;
import java_oop_homeWork.src.model.display.displayObjects.DisplayPerson;
import java_oop_homeWork.src.model.display.displayObjects.DisplayPersonWithoutChildren;

import java.io.Serializable;
import java.util.*;
import java.text.*;

public class Person implements Serializable, Comparable<Person> {
    private int id;
    private FamilyTree family;
    private Date dateBirth;
    private String name;
    private String surName;
    private Sex sex;
    private Person father;
    private Person mother;
    private TreeSet<Person> children;
    private Date dateDeath;
    private boolean alive;

    public Person(int id, String name, String surName, Sex sex, String dateBirth, String dateDeath, boolean alive) {
        SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.sex = sex;
        if (dateBirth != null) {
            try {
                this.dateBirth = ft.parse(dateBirth);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (dateDeath != null) {
            try {
                this.dateDeath = ft.parse(dateDeath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.alive = alive;
        this.children = new TreeSet<>();
    }
    public Person(int id, String name, String surName, Sex sex, String dateBirth, String dateDeath) {
        this(id, name, surName, sex, dateBirth, dateDeath, false);
    }
    public Person(int id, String name, String surName, Sex sex, String dateBirth, boolean alive) {
        this(id, name, surName, sex, dateBirth, null, alive);
    }
    public Person(int id, String name, String surName, Sex sex, boolean alive) {
        this(id, name, surName, sex, null, null, alive);
    }
    public Person(int id, String name, String surName, Sex sex, String dateDeath) {
        this(id, name, surName, sex, null, dateDeath, false);
    }
    public Person(int id, String name, String surName, Sex sex) {
        this(id, name, surName, sex, null, null, true);
    }

    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surName;
    }

    public FamilyTree getFamily() { return this.family; }
    public void setFamily(FamilyTree family) { this.family = family; }

    public Person getMother() { return this.mother; }
    public boolean setMother(Person mother) {
        if (this.mother == null) {
            this.mother = mother;
            return true;
        }
        return false;
    }
    public Person getFather() { return this.father; }
    public boolean setFather(Person father) {
        if (this.father == null) {
            this.father = father;
            return true;
        }
        return false;
    }
    public TreeSet<Person> getChildren() { return this.children; }
    public void addChild(Person child) { this.children.add(child); }

    public Sex getSex() { return this.sex; }

    public boolean setParent(Person parent) {
        if (parent.getSex() == Sex.men) {
            return this.setFather(parent);
        }
        return this.setMother(parent);
    }

    public Date getDateBirth() {
        return dateBirth;
    }
    public Date getDateDeath() {
        return dateDeath;
    }

    public boolean getAlive() { return alive;}

    public String personToStrWithoutChildren() {
        return new DisplayPersonWithoutChildren(new DisplayInfo("", ": ", " | ", ""), this).prepareForPrint();
    }

    public String personToStr() {
        return new DisplayPerson(new DisplayInfo("\n", ": ", " | ", ""), this).prepareForPrint();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return id == person.id;
        }
        return false;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public int compareTo(Person person) {
        return this.id - person.getID();
    }

}
