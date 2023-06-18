package FamilyTree.model.human;

import FamilyTree.model.familyTree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Human implements Serializable, TreeItem<Human> {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;

    private ArrayList<Human> childrens;


    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        childrens = new ArrayList<>();
    }
    public Human(String name, Gender gender){
        this(name, gender, null, null);
    }
    public Human(String name, Gender gender, Human father, Human mother) {
        this(name, null , null, gender, father, mother);
    }

    public boolean addChild(Human child){
        if(!childrens.contains(child)){
            childrens.add(child);
            return true;
        }
        return false;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public ArrayList<Human> getChildrens() {
        return childrens;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append("пол: ");
        sb.append(gender);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    public String getMotherInfo(){
        String res = " мама: ";
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "папа: ";
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (childrens.size() != 0){
            res.append(childrens.get(0).getName());
            for (int i = 1; i < childrens.size(); i++) {
                res.append(", ");
                res.append(childrens.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
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
        return human.getName().equals((getName()));
    }
}
