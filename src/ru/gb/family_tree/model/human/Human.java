package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.tree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Human implements Serializable, Comparable<Human>, TreeItem<Human> {
    private int id;
    private String fullName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human father;
    private Human mother;
    private List<Human> parents;
    private List<Human> children;

    // father, mother Name
    private String nameFather;
    private String nameMother;

    public Human(int id, String fullName, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human father, Human mother) {
//        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.father = father;
        this.mother = mother;
        parents = new ArrayList<>();
        if(father != null) {
            parents.add(father);
        }
        if(mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }



//    public Human(int id ,String fullName, Gender gender, LocalDate dateOfBirth,Human father, Human mother
//    ) {this(id, fullName, gender, dateOfBirth, null, father, mother);
//    }
//    public Human(int id ,String fullName, Gender gender, LocalDate dateOfBirth/*, LocalDate dateOfDeath*/) {
//        this(id, fullName, gender, dateOfBirth/*, dateOfDeath*/, null, null);
//    }

        public Human(int id, String fullName, Gender gender, LocalDate dateOfBirth) {
        this(id, fullName, gender, dateOfBirth, null, null, null);
    }
    public String getFullName() {return fullName;}
    public Gender getGender() {return gender;}
    public List<Human> getParents() {return parents;}

    public String getNameFather() {
        return nameFather;
    }

    public String getNameMother() {
        return nameMother;
    }

    public int getId() {return id;}
    public List<Human> getChildren() {return children;}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}
//    public void setDateOfDeath(LocalDate dateOfDeath) {this.dateOfDeath = dateOfDeath;}

    public LocalDate getDateOfBirth() {return dateOfBirth;}
    public LocalDate getDateOfDeath() { return dateOfDeath;}


    public void addChild(Human child) {
        if(!children.contains(child)) {
            children.add(child);
        }
    }

    public void addParent(Human parent) {
        if(!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    public Human getFather() {
        for (Human parent: parents) {
            if(parent.getGender() == Gender.муж){
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent: parents) {
            if(parent.getGender() == Gender.жен){
                return  parent;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(id);
//        stringBuilder.append(": ");
        stringBuilder.append(fullName);
        stringBuilder.append(", ");
        stringBuilder.append(getGender());
        stringBuilder.append(", ");
        stringBuilder.append(getAge());
        stringBuilder.append(", ");
//        stringBuilder.append(getMotherInfo());
////        stringBuilder.append("мать: ");
////        stringBuilder.append(mother);
//        stringBuilder.append(", ");
//        stringBuilder.append(getFatherInfo());
////        stringBuilder.append("отец: ");
////        stringBuilder.append(father);
//        stringBuilder.append(", ");
//        stringBuilder.append(getChildrenInfo());

        return  stringBuilder.toString();
    }


    public String getMotherInfo(){
        String str = "мать: ";
        mother = getMother();
        if (mother != null){
            str += mother.getFullName();
        }else{
            str += null;
        }
        return str;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        father = getFather();
        if (father != null){
            res += father.getFullName();
        }else {
            res += null;
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getFullName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getFullName());
            }
        }else{
            res.append("null");
        }
        return res.toString();
    }

    public int getAge() {
        if (dateOfDeath == null){
            return getPeriod(dateOfBirth, LocalDate.now());
        }
        else {
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }
    public int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period age = Period.between(dateOfBirth, dateOfDeath);
        return age.getYears();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getFullName().equals(getFullName());
    }

    @Override
    public int compareTo(Human o) {
        return fullName.compareTo(o.fullName);
    }
}
