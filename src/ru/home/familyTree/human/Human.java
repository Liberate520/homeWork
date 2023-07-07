package ru.home.familyTree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath,
                 Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        parents = new ArrayList<>();
        if(father != null){
            parents.add(father);
        }
        if(mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }
    public Human(){
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, Human father, Human mother){
        this(name, gender, dateOfBirth, null, father, mother);
    }

    public String getName() {
        return name;
    }

    public void addChild(Human child){
        children.add(child);
    }

    public void addParent(Human parent){
        children.add(parent);
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public Human getMather(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ФИО: ");
        stringBuilder.append(name);
        stringBuilder.append(", возраст: ");
        stringBuilder.append(getAge());
        stringBuilder.append(", ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getChildrenInfo());
        return stringBuilder.toString();
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMather();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "нет данных";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        } else {
            res += "нет данных";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder child = new StringBuilder();
        child.append("дети: ");
        if (children.size() != 0) {
            child.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                child.append(", ");
                child.append(children.get(i).getName());
            }
        } else {
            child.append("нет данных");
        }
        return child.toString();
    }

    public int getAge(){
        if (dateOfDeath == null) {
            return getPeriod(dateOfBirth, LocalDate.now());

        } else {
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }
    private int getPeriod(LocalDate dateOfBirth,LocalDate dateOfDeath) {
        Period res = Period.between(dateOfBirth, dateOfDeath);
        return res.getYears();
    }
}
