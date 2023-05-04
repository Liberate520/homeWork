package model.human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.tree.TreeItem;


public class Human implements Serializable, Comparable<Human>, TreeItem<Human> {
    private String name;
    private String surName;
    private String fatherName;
    private Human mother;
    private Human father;
    private List<Human> childrens;
    private Gender gender;
    private int age;
    

    private Human(String name, String surName, String fatherName, Human mother, Human father,
            ArrayList<Human> childrens, Gender gender, int age) {
        this.name = name;
        this.surName = surName;
        this.fatherName = fatherName;
        this.mother = mother;
        this.father = father;
        this.childrens = childrens;
        this.gender = gender;
        this.age = age;
    }

    public Human(String name, String surName, String fatherName, Human mother, Human father, Gender gender, int age) {
        this(name, surName, fatherName, mother, father, new ArrayList<Human>(), gender, age);
    }

  
    public Human(String name, String surName, Gender gender,int age) {
        this(name, surName, "", null, null, new ArrayList<Human>(), gender, age);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    

    @Override
    public int compareTo(Human o) {
        return this.surName.compareTo(o.surName);   
        
    }

    public String getFullInfo() {
        String genderString = this.gender.equals(Gender.Male) ? "мужской" : "женский";
        if (childrens.size() > 0) {
            if (this.fatherName != null && this.fatherName != "") {
                return String.format("%s %s %s, пол - %s, возраст - %d, мать - %s, отец - %s, дети - %s", this.surName,
                        this.name,
                        this.fatherName, genderString, this.age, this.mother == null ? "нет" : this.mother.getShortInfo(),
                        this.father == null ? "нет" : this.father.getShortInfo(),
                        getChildrenInfo(this.childrens));
            } else {
                return String.format("%s %s, пол - %s, возраст - %d, мать - %s, отец - %s, дети - %s", this.surName,
                        this.name,
                        genderString, this.age, this.mother == null ? "нет" : this.mother.getShortInfo(),
                        this.father == null ? "нет" : this.father.getShortInfo(),
                        getChildrenInfo(this.childrens));
            }
        } else {

            if (this.fatherName != null && this.fatherName != "") {
                return String.format("%s %s %s, пол - %s, возраст - %d, мать - %s, отец - %s, детей нет", this.surName,
                        this.name,
                        this.fatherName,
                        genderString, this.age, this.mother == null ? "нет" : this.mother.getShortInfo(),
                        this.father == null ? "нет" : this.father.getShortInfo());
            } else {
                return String.format("%s %s, пол - %s, возраст - %d, мать - %s, отец - %s, детей нет", this.surName,
                        this.name,
                        genderString, this.age, this.mother == null ? "нет" : this.mother.getShortInfo(),
                        this.father == null ? "нет" : this.father.getShortInfo());
            }
        }
    }

    public String getShortInfo() {
        String genderString = this.gender.equals(Gender.Male) ? "мужской" : "женский";
        if (childrens.size() > 0) {
            if (this.fatherName != null && this.fatherName != "") {
                return String.format("%s %s %s, пол - %s, возраст - %d", this.surName, this.name, this.fatherName,
                        genderString, this.age);
            } else {
                return String.format("%s %s, пол - %s, возраст - %d", this.surName, this.name, genderString, this.age);
            }
        } else {

            if (this.fatherName != null && this.fatherName != "") {
                return String.format("%s %s %s, пол - %s, возраст - %d", this.surName, this.name,
                        this.fatherName, genderString, this.age);
            } else {
                return String.format("%s %s, пол - %s, возраст - %d", this.surName, this.name,
                        genderString, this.age);
            }
        }
    }

    public String getFullName() {
        String temp = ((this.fatherName != null && (!this.fatherName.equals(""))) ? " " + this.fatherName : "");
        return this.surName + " " + this.name + temp;
    }

    public List<Human> getChildrens() {

        return this.childrens;
    }

    public String getChildrenInfo(List<Human> childrens) {
        int count = childrens.size();
        if (count > 0) {
            String result = "";
            for (int i = 0; i < childrens.size() - 1; i++) {
                result += childrens.get(i).getFullName() + ", ";
            }
            result += childrens.get(childrens.size() - 1).getFullName();
            return result;
        }
        return "детей нет";
    }

    public Human getMother() {
        return this.mother;
    }

    public void addParent(Human human) {
        if (human.getGender().equals(Gender.Male)) {
            this.father = human;
        } else {
            this.mother = human;
        }
    }

    public void removeParent(Human human) {
        if (human.getGender().equals(Gender.Female) && this.mother.equals(human)) {
            this.mother = null;
        } else if (human.getGender().equals(Gender.Male) && this.father.equals(human)) {
            this.father = null;
        }
    }

    public Human getFather() {
        return this.father;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void addChildren(Human newHuman) {
        List<Human> childrens = getChildrens();
        if (!childrens.contains(newHuman)) {
            childrens.add(newHuman);
            this.childrens = childrens;
        }
    }

    public void removeChildren(Human newHuman) {
        List<Human> childrens = getChildrens();
        if (childrens.contains(newHuman)) {
            childrens.remove(newHuman);
            this.childrens = childrens;
        }
    }

    public String toString() {
        String temp = ((this.fatherName != null && (!this.fatherName.equals(""))) ? " " + this.fatherName : "");
        return this.surName + " " + this.name + temp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return this.getFullName().equals(human.getFullName());
    }
}
