package ru.gb.family_tree_homework.family_tree_API.human;

import ru.gb.family_tree_homework.family_tree_API.family_tree.TreeNode;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeNode<Human> {
    private long id;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother, father;
    private Human spouse;
    private List<Human> children;
    private String name;

    //Constructors
    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        this.id = -1;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.name = name;
        this.children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(name, gender, birthDate, null, mother, father);
    }

    //ID
    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }
    //Gender
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    //Dates
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(int day, int month, int year) {
        this.deathDate = LocalDate.of(year, month, day);
    }

    //Age
    public Integer getAge(){
        LocalDate currentDate = LocalDate.now();
        Period diff;
        if(deathDate == null) {
            diff = Period.between(getBirthDate(), currentDate);
        } else {
            diff = Period.between(getBirthDate(), getDeathDate());
        }
        return diff.getYears();
    }

    //Parents
    public void setFather(Human father){
        this.father = father;
    }

    public void setMother(Human mother){
        this.mother = mother;
    }
    public boolean addParent(Human parent){
        if(parent.getGender().equals(Gender.Male)){
            setFather(parent);
        } else {
            setMother(parent);
        }
        return true;
    }

    public List<Human> getParents(){
        List<Human> parents = new ArrayList<>(2);
        if(father != null){
            parents.add(father);
        } if(mother != null){
            parents.add(mother);
        }
        return parents;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    //Spouse
    public void setSpouse(Human spouse){
        this.spouse = spouse;
    }

    public Human getSpouse(){
        return spouse;
    }

    //Children
    public List<Human> getChildren() {
        return children;
    }

    public boolean addChild(Human child) {
        if(!this.children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    //Name
    public String getName() {
        return name;
    }

    //Others
    @Override
    public String toString() {
        return getInfo();
    }
    public String nullChecker(Human human){
        StringBuilder sB = new StringBuilder();
        if(human != null){
            sB.append(human.getName());
            return sB.toString();
        } else {
            sB.append("unknown");
            return sB.toString();
        }
    }

    public String nullChecker(List<Human> humanList){
        StringBuilder sB = new StringBuilder();
        if(!humanList.isEmpty()) {
            sB.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sB.append(", ").append(children.get(i).getName());
            }
        } else {
            sB.append("none");
        }
        return sB.toString();
    }
    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID: ")
                .append(id)
                .append(". name: ")
                .append(name)
                .append(", age: ")
                .append(getAge())
                .append(", birth date: ")
                .append(birthDate)
                .append(", gender: ")
                .append(gender)
                .append(", mother: ")
                .append(nullChecker(mother))
                .append(", father: ")
                .append(nullChecker(father))
                .append(", spouse: ")
                .append(nullChecker(spouse))
                .append(", children: ")
                .append(nullChecker(children));
        return stringBuilder.toString();
    }

    //Equals
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human human)){
            return false;
        }
        return human.getId() == getId();
    }
}
