package project;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String sex;
    private Integer year_of_birth;
    private User father;
    private User mother;
    private List<User> children;

    public User(String name, String sex, Integer year_of_birth, User father, User mother) {
        this.name = name;
        this.sex = sex;
        this.year_of_birth = year_of_birth;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }
    
    public User(String name, String sex, Integer year_of_birth){
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

    public User getFather() {
        return father;
    }

    public User getMother() {
        return mother;
    }
    
    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<User> getChildren() {
        return children;
    }

    public void addChild(User child) {
        this.children.add(child);
    }

    public String getChildrenName(List<User> children) {
        String name_children = "";
        if (!children.isEmpty()) {
            for (int i = 0; i < children.size() - 1; i++) {
                name_children += children.get(i).getName() + ", ";
            }
            name_children += children.get(children.size() - 1).getName();
        } else name_children = "Неизвестно";
        return name_children;
    }

    public String getFatherName(User human) {
        String name_father; 
        if (human == null) name_father = "Неизвестно";
        else name_father = father.getName();
        return name_father;
    }

    public String getMotherName(User human) {
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
