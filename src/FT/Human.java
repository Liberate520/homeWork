package FT;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> { 
    private String name; 
    private String gender;
    private Integer age; 
    private Human father; 
    private Human mother; 
    private List<Human> children;

    public Human(String name, String gender, Integer age, Human father, Human mother) {
        this.name = name;      
        this.gender = gender;  
        this.age = age;       
        this.father = father;  
        this.mother = mother;  
        this.children = new ArrayList<>(); 
    }

    public Human(String name, String gender, int age) {
        this(name, gender, age, null, null); 
    }

    public Human() {
        this(null, null, null, null, null);
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sbHum = new StringBuilder();
        sbHum.append("Имя ").append(name).append("\n");    
        sbHum.append("Пол ").append(gender).append("\n");
        sbHum.append("Возраст ").append(age).append("\n");
        if (!(father == null)) {
            sbHum.append("Отец ").append(father.getName()).append("\n");
        }
        if (!(mother == null)) {
            sbHum.append("Мать ").append(mother.getName()).append("\n");
        }
        if (children.size() > 0) {      // изменено. теперь без this
            for (Human child : this.children) {
                if (child.getGender().equals("М")) {
                    sbHum.append("Сын ").append(child.getName());
                    sbHum.append("\n");
                } else if (child.getGender().equals("Ж")) {
                    sbHum.append("Дочь ").append(child.getName());
                    sbHum.append("\n");
                }
            }
        }
        return sbHum.toString();
    }

    public String getAllChildren() {
        StringBuilder kids = new StringBuilder();
        if (this.children.size() > 0) {
            kids.append("У ").append(this.getName()).append(" есть ");
            for (Human child : this.children) {
                kids.append(child.getGender().equals("М") ? "Сын" : "Дочь").append(" - ").append(child.getName()).append(" ");
            }
        } else {
            kids.append("У ").append(this.getName()).append(" детей нет.");
        }
        return kids.toString();
    }

    public String getAllSistersOrBrothers(String gender) {
        StringBuilder sistOrBroth = new StringBuilder();
        if (!(this.father == null)) {
            if (this.father.children.size() > 0) {
                for (Human child : this.father.children) {
                    if ((child.getGender().equals(gender)) & (child != this)) {
                        sistOrBroth.append(child.getName()).append(" ");
                    }
                }
            }
            if (sistOrBroth.length() == 0) {
                sistOrBroth.append("У ").append(this.getName()).append(gender.equals("Ж") ? " нет сестёр" : " нет братьев");
            }
        } else sistOrBroth.append("У ").append(this.getName()).append(" неизвестны родители.");
        return sistOrBroth.toString();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }

    public void addChild(Human child){
        this.getChildren().add(child);
    }

}