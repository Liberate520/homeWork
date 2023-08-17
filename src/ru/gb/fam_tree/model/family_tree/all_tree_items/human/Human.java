package ru.gb.fam_tree.model.family_tree.all_tree_items.human;

import ru.gb.fam_tree.model.family_tree.all_tree_items.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class Human implements FamilyTreeItem<Human>, Serializable, Comparable<Human> {

    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private List<Human> parents, childrens;
    private Human spouse;

    public int getDaysOfLife(){
        int currentDays = 0;
        if(deathDate == null){
            currentDays = (LocalDate.now().getYear() - birthDate.getYear())*365 + (LocalDate.now().getDayOfYear() - birthDate.getDayOfYear());
        }
        else {
            currentDays = (deathDate.getYear() - birthDate.getYear())*365 + (deathDate.now().getDayOfYear() - birthDate.getDayOfYear());
        }
        return currentDays;
    }


    public Human(String name, Gender gender, LocalDate birthDate,
                 LocalDate deathDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if(father != null){
            parents.add(father);
        }
        if(mother != null){
            parents.add(mother);
        }
        this.childrens = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null, null);
    }

    public Human(){
        this(null,null,null,null,null,null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChild(Human child){
        if(!childrens.contains(child)){
            childrens.add(child);
        }
    }

    public void addParent(Human parent){
        if(!parents.contains(parent)){
            parents.add(parent);
        }
    }

    public Human getMother(){
        for (Human parent: parents){
            if(parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public Human getFather(){
        for(Human parent:parents){
            if(parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    private int getAge(){
        if(deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }
        else{
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate,deathDate);
        return diff.getYears();
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public String toString(){
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrensInfo());
        return sb.toString();
    }

    public String getSpouseInfo(){
        String res = "spouse: ";
        if(spouse == null){
            res += "none";
        }
        else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "mother: ";
        Human mother = getMother();
        if(mother != null){
            res += mother.getName();
        }
        else {
            res += "unknown";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "father: ";
        Human father = getFather();
        if(father != null){
            res += father.getName();
        }
        else{
            res += "unknown";
        }
        return res;
    }

    public String getChildrensInfo(){
        StringBuilder res = new StringBuilder();
        res.append("childs: ");
        if(childrens.size() != 0) {
            res.append(childrens.get(0).getName());
            for (int i = 1; i < childrens.size(); i++) {
                res.append(", ");
                res.append(childrens.get(i).getName());
            }
        }
        else {
            res.append("none");
        }
        return res.toString();
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}



