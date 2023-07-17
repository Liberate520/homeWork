package ru.gb.family_tree;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private Human mother, father;
    private List<Human> childrens;
    private Gender gender;
    private String name;
    private LocalDate birthday;
    public Human (String name, LocalDate birthday, Gender gender){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        childrens = new ArrayList<>();
    }
    public void setMother(Human mother){
        this.mother = mother;
        mother.setChildren(this);
    }
    public void getFather() {
        System.out.println(father.name);
    }

    public void getMother() {
        System.out.println(mother.name);
    }

    public void setFather(Human father) {
        this.father = father;
        father.setChildren(this);
    }

    public void setChildren(Human children){
        this.childrens.add(children);
    }
    public void printChildren(){
        for (Human children: childrens){
            children.getName();
        }
    }
    public void getGender() {
        System.out.println(gender);
    }

    public void getName() {
        System.out.println(name);
    }

    public void getAge(){
        LocalDate currentDate = LocalDate.now();
        long age = birthday.until(currentDate, ChronoUnit.YEARS);
        System.out.println(this.name + ", Age " + age + " years");
    }

}
