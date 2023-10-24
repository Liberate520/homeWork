package ru.gb.human;

import java.util.ArrayList;
import java.util.List;

public class Parent extends Human{
    private List<Human> children;
    public Parent(String name, Gender gender, Human father, Human mother, String bornDate) {
        super(name, gender, father, mother, bornDate);
        this.children = new ArrayList<>();
    }

    public Parent(String name, Gender gender, String bornDate) {
        super(name, gender, bornDate);
        this.children = new ArrayList<>();
    }

    public String getChildren(){
        StringBuilder sb = new StringBuilder();
        sb.append("Дети родителя ")
                .append(getName())
                .append(":");
        for (Human child: children) {
            sb.append(" ").append(child.getName()).append(",");
        }
        return sb.toString();
    }

    public void addChild(Human child){
        children.add(child);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
