package Homeworks.homeWork.src.main.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String surname;
    private LocalDate born;
    private Human mother, father;
    private List<Human> children;

    private LocalDate death;
    private Gender gender;

    public LocalDate getDeath() {
        return death;
    }

    public void setDeath(LocalDate death) {
        this.death = death;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human(String name, String surname, LocalDate born, Gender gender) {
        this.born = born;
        this.name = name;
        this.surname = surname;
        this.children = new ArrayList<>();
        this.gender = gender;
    }

    public void addChildren(Human children) {
        this.children.add(children);
    }

    public String showChildren() {
        StringBuilder sb = new StringBuilder();
        sb.append("Дети " + this.name + " " + this.surname + ": ");
        for (Human i: children) {
            sb.append(i.toString() + "\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nЭтого человека зовут: " +
                this.name + " " + this.surname +
                "\nОн(а) родился(ась): " + this.born
                + "\nОн(а) " + this.gender + " пола "
                + "\nЕго(ее) мать: " + this.mother
                + "\nЕго(ее) отец: " + this.father);
        return sb.toString();
    }
}
