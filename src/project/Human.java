package project;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String sex;
    private Human father;
    private Human mother;
    private List<Human> children;
    
    public Human(String name, String sex, Human father, Human mother) {
        this.name = name;
        this.sex = sex;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }
    
    public Human(String name, String sex){
        this(name, sex, null, null);
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }
    
    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public String getChildrenName(List<Human> children) {
        String name_children = "";
        if (!children.isEmpty()) {
            for (int i = 0; i < children.size() - 1; i++) {
                name_children += children.get(i).getName() + ", ";
            }
            name_children += children.get(children.size() - 1).getName();
        } else name_children = "Неизвестно";
        return name_children;
    }

    public String getFatherName(Human human) {
        String name_father; 
        if (human == null) name_father = "Неизвестно";
        else name_father = father.getName();
        return name_father;
    }

    public String getMotherName(Human human) {
        String name_mother; 
        if (human == null) name_mother = "Неизвестно";
        else name_mother = mother.getName();
        return name_mother;
    }

    @Override
    public String toString() {
        return "Имя = " + name + 
               ", Пол = " + sex + 
               ", Отец = " + getFatherName(father) + 
               ", Мать = " + getMotherName(mother) + 
               ", Дети = " + getChildrenName(children);
    }
}