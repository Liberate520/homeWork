package lesson1;

import java.util.ArrayList;

public class Human {
    private String name;
    private String gender;
    private Human father;
    private Human mother;
    private ArrayList<Human> children;
/** 
 * конструкторы
 */
    public Human(String name, String gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();

    }
    public Human(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public Human() {
    }
/** 
 * геттеры и сеттры
 */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }
/** 
 * печать списка детей
 */
    public void printChildren(ArrayList<Human> ch) {
        for (Human h : ch) {
            System.out.println(h);
        }
    }
/** 
 * перегрузка toString
 */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ")
                .append(name)
                .append(" пол: ")
                .append(gender);
        String res = sb.toString();
        return res;

    
    }

}
