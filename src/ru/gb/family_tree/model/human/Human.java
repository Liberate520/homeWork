package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.family_tree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Human implements Serializable, TreeItem<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate deathDate;
    private List<Human> parents;
    private Human mother;
    private Human father;
    private String birthDate;
    private List<Human> children;
    private Human spouse;

    public Human(long id, String name, String birthDate, Gender gender, Human father, Human mother,
                 List<Human> children) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }
    public Human(int id, String name, String birthDate, Gender gender, Human father, Human mother) {
        this(id, name, birthDate, gender, father, mother, null);
    }

    public Human(int id, String name, String birthDate, Gender gender, List<Human> children) {
        this(id, name, birthDate, gender, null, null, children);
    }

    public Human(int id, String name, String birthDate, Gender gender) {
        this(id, name, birthDate, gender, null, null, null);
    }

    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public int getAge(){
        if (deathDate == null){
            return getPeriod(LocalDate.parse(birthDate), LocalDate.now());
        } else {
            return getPeriod(LocalDate.parse(birthDate), deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }
    public String getBirthDate() {

    return birthDate;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст:  ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(".");
        return sb.toString();
    }

    public String getSpouseInfo(){
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if (father == null){
            res += "неизвестен";
        } else {
            res += father.getFather();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother == null){
            res += "неизвестна";
        } else {
            res += mother.getMother();
        }
        return res;
    }

        @Override
        public boolean equals (Object obj){
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Human)) {
                return false;
            }
            Human human = (Human) obj;
            return human.getId() == getId();
        }
}

