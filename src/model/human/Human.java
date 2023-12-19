package model.human;

import model.family_tree.FamilyItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable,Comparable<Human>,FamilyItem<Human> {
    private long id;
    private String name;
    private Gender gender;
    private Human mother, father;
    public List<Human> child;
    private LocalDate birthDay;
    private LocalDate deathDay;

    public Human(){

    }

    public Human(String name, Gender gender, LocalDate birthDay) {
        id = -1;
        this.name = name;
        this.mother = null;
        this.father = null;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deathDay = null;
        child = new ArrayList<>();
    }

    public Human(String name, Gender gender,Human mother,Human father, LocalDate birthDay) {
        this.gender = gender;
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.birthDay = birthDay;
        child = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @Override
    public Gender gender() {
        return gender;
    }

    public String getGender() {
        if(gender() == Gender.Mail){
            return "Мужчина";
        }else{
            return "Женщина";
        }
    }

    public void setId(long id) {
        this.id = id;
    }


    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public String setChild() {
        StringBuilder sb = new StringBuilder();
        for (Human human:child) {
            if(!child.isEmpty()) {
                sb.append(human.getName() + " " + human.getAge() + " " +  human.getGender() + "\n");
            }
        }
        return sb.toString();
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id:");
        sb.append(getId() + " ");
        sb.append(name).append(" ");
        sb.append("Возраст : ");
        sb.append(getAge()).append(" ");
        sb.append(getGender());
        sb.append("\n");
        return sb.toString();
    }

    public boolean addChildren(String name,Gender gender,LocalDate localDate){
        if(!child.contains(name)) {
            child.add(new Human(name,gender,localDate));
            return true;
        }
        return false;
    }

    private int getPeriod(LocalDate birthDay,LocalDate deathDay){
        Period diff = Period.between(birthDay,deathDay);
        return diff.getYears();
    }

    public int getAge(){
        if(deathDay == null){
            return getPeriod(birthDay,LocalDate.now());
        } else {
            return getPeriod(birthDay,deathDay);
        }
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }

}
