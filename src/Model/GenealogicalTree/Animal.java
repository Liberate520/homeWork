package Model.GenealogicalTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable, Comparable<Animal> {
    private int id;
    private String name;
    private Sex sex;
    private int birthYear;
    private Animal father;
    private Animal mother;
    private Animal partner;
    private List<Animal> children;

    public Animal(int id, String name, Sex sex, int birthYear) {
        this(id, name, sex, birthYear, null, null, null);
    }

    public Animal(int id, String name, Sex sex, int birthYear, 
    Animal father, Animal mother, Animal partner) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthYear = birthYear;
        this.father = father;
        this.mother = mother;
        this.partner = partner;
        this.children = new ArrayList<>();
    }

    /**
     * * Метод добавления ребенка к человеку.
     * @param somebody Ребенок, которого нужно добавить.
     * @param children Список детей человека
     */
    public List<Animal> addChild (Animal somebody) {
        if (!this.children.contains(somebody)){
            this.children.add(somebody);
        }
        return children;
    }

    public List<Animal> getChildren() {
        return children;
    }

    public String childrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Дети: ");
        if (children.size() != 0) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        } else {
            sb.append("отсутствуют");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("id %d, %s, пол %s, %s г.р.", id, name, sex, birthYear);
    }
    
    @Override
    public int compareTo(Animal o) {
        return name.compareTo(o.name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Animal getFather() {
        return father;
    }

    public void setFather(Animal father) {
        this.father = father;
    }

    public Animal getMother() {
        return mother;
    }

    public void setMother(Animal mother) {
        this.mother = mother;
    }

    public Animal getPartner() {
        return partner;
    }

    public void setPartner(Animal partner) {
        this.partner = partner;
    }
}