package ru.gb.family_tree.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private LocalDate birthDay;
    private  LocalDate deathDay;
    private Gender gender;
    private Human mother;
    private Human father;
    private Human spouse;
    private List<Human> children;

    public Human (String name, Gender gender, LocalDate birthDay, LocalDate deathDay, Human mother, Human father){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human (String name, Gender gender, LocalDate birthDay){
        this(name, gender, birthDay, null, null, null);
    }
    public Human (String name, Gender gender, LocalDate birthDay, Human mother, Human father){
        this( name, gender, birthDay, null, mother, father);
    }

    public int getId() {return id;}

    public String getName() {return name;}

    public LocalDate getBirthDay() {return birthDay;}

    public LocalDate getDeathDay() {return deathDay;}

    public Gender getGender() {return gender;}

    public Human getMother() {return mother;}

    public Human getFather() {return father;}

    public Human getSpouse() {return spouse;}

    public List<Human> getChildren() {return children;}

    public void setId(int id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setBirthDay(LocalDate birthDay) {this.birthDay = birthDay;}

    public void setDeathDay(LocalDate deathDay) {this.deathDay = deathDay;}

    public void setGender(Gender gender) {this.gender = gender;}

    public void setSpouse(Human spouse) {this.spouse = spouse;}

    public void setMother(Human mother) {this.mother = mother;}

    public void setFather(Human father) {this.father = father;}

    public void addChildren(Human child){
        if (!children.contains(child)){
            children.add(child);
        }
    }

    public void addParents(Human parent){
        if (parent.gender.equals(Gender.Male)){
            setFather(parent);
        }
        else setMother(parent);
    }

    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>(2);

        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        return parents;
    }

    public String getAge(){
        if (deathDay == null){
            return Integer.toString(Period.between(birthDay, LocalDate.now()).getYears());
        }
        else {
            StringBuilder stringBuilder = new StringBuilder(name);
            stringBuilder.append(" ").append(" умер(ла) в возрасте ").
                    append(Period.between(birthDay, deathDay).getYears()).append(" лет");
            return stringBuilder.toString();

        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(id);
        stringBuilder.append(", имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", пол: ");
        stringBuilder.append(gender);
        stringBuilder.append(", возраст: ");
        stringBuilder.append(getAge());
        stringBuilder.append(", ");
        stringBuilder.append(getSpouseInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getChildrenInfo());

        return stringBuilder.toString();
    }

    public String getSpouseInfo(){
        String res = "супруг(а): ";
        if (spouse == null){
            res += "нет";
        }
        else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "мать: ";
        if (mother == null){
            res += "неизвестна";
        }
        else {
            res += mother.getName();
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        if (father == null){
            res += "неизвестен";
        }
        else {
            res += father.getName();
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder resChildren = new StringBuilder("дети: ");
        if (children.size() != 0){
            resChildren.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                resChildren.append(", ").append(children.get(i).getName());
            }
        }
        else {
            resChildren.append("отсутствуют");
        }
        return resChildren.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
