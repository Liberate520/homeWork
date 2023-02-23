package project;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String sex;
    private Integer year_of_birth;
    private Human father;
    private Human mother;
    private List<Human> children;
    
    public Human(String name, String sex, Integer year_of_birth, Human father, Human mother) {
        this.name = name;
        this.sex = sex;
        this.year_of_birth = year_of_birth;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }
    
    public Human(String name, String sex, Integer year_of_birth){
        this(name, sex, year_of_birth, null, null);
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }
    
    public Integer getYearOfBirth() {
        return year_of_birth;
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
               ", Год рождения = " + year_of_birth + 
               ", Отец = " + getFatherName(father) + 
               ", Мать = " + getMotherName(mother) + 
               ", Дети = " + getChildrenName(children);
    }
}