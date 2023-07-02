package ru.gb.FamilyTree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String fullName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Human> parents;
    private List<Human> children;

    public Human(String fullName, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human father,
                 Human mother) {
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        parents = new ArrayList<>();
        if(father != null) {
            parents.add(father);
        }
        if(mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }
    public String getFullName() {return fullName;}
    public Gender getGender() {return gender;}
    public List<Human> getParents() {return parents;}
    public List<Human> getChildren() {return children;}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public void setDateOfDeath(LocalDate dateOfDeath) {this.dateOfDeath = dateOfDeath;}

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
            if(parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }
    public Human getMother() {
        for (Human parent: parents) {
            if(parent.getGender() == Gender.Female){
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
        stringBuilder.append(fullName);
        stringBuilder.append(", ");
        stringBuilder.append(getGender());
        stringBuilder.append(", ");
        stringBuilder.append(getAge());
        stringBuilder.append(", ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getChildrenInfo());
        return  stringBuilder.toString();
    }

    public String getMotherInfo(){
        String str = "mother: ";
        Human mother = getMother();
        if (mother != null){
            str += mother.getFullName();
        }else{
            str += null;
        }
        return str;
    }
    public String getFatherInfo(){
        String res = "father: ";
        Human father = getFather();
        if (father != null){
            res += father.getFullName();
        }else {
            res += null;
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("child: ");
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

//    public String toString() {return getInfo();}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getFullName().equals(getFullName());
    }
}
