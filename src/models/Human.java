package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import enums.Gender;

public class Human implements Serializable{
    private String uuid;
    private String name;
    private String lastName;
    private String secondName;
    private Gender gender;
    private Human spouse;
    private Human parentFather;
    private Human parentMother;
    private int generation = 0;
    private List<Human> children;
    protected Object fieldName;

    public Human(String lastName, String name, String secondName, Gender gender) {
        this.uuid = UUID.randomUUID().toString();
        this.secondName = secondName;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Human(String lastName, String name, String secondName, Gender gender, Human parentFather, Human parentMother) {
        this(lastName, name, secondName, gender);
        this.parentFather = parentFather;
        this.parentMother = parentMother;
    }

    @Override
    public String toString() {
        String text = "";
        if (this.children  != null) {
            for (Human hum : this.children) {
                text = text + "\n" + hum.getUuid() + " -> " + hum.getFIOtoString();
            }
        }

        return this.getUuid() + " -> " + this.getFIOtoString() + "\n"
            + "пол: " + (gender == Gender.MAN ? "мужской" : "женский") + "\n"
            + (
                this.getSpouse() != null ?
                (
                    (this.getSpouse().getGender() == Gender.MAN ? "муж: " : "жена: ")
                    + "\n" + this.getSpouse().getUuid() + " -> " + this.getSpouse().getFIOtoString() + "\n"
                ) : ""
            )
            + "отец: "
            + (
                this.parentFather != null ? 
                "\n" + this.parentFather.getUuid() + " -> " + this.parentFather.getFIOtoString() : 
                "отсутствует"
            ) + "\n"
            + "мать: "
            + (
                this.parentMother != null ? 
                "\n" + this.parentMother.getUuid() + " -> " + this.parentMother.getFIOtoString() :
                 "отсутствует"
            ) + "\n"
            +  (text.length() > 0 ? "дети: " + text : "дети: нет");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setParentFather(Human parentFather) {
        if (this.parentFather != null) {
            removeChild(this.parentFather, this);
        }
        
        this.parentFather = parentFather;
        if (this.generation == 0) {
            this.generation = parentFather.getGeneration() + 1;
        }

        addChild(parentFather, this);
    }

    public void setParentMother(Human parentMother) {
        if (this.parentMother != null) {
            removeChild(this.parentMother, this);
        }
        
        this.parentMother = parentMother;
        if (this.generation == 0) {
            this.generation = parentFather.getGeneration() + 1;
        }

        addChild(parentMother, this);
    }

    public static void removeChild(Human human, Human child) {
        List<Human> childParentMother = new ArrayList<>(human.getChildren());
        childParentMother.remove(child);
        human.setChildren(childParentMother);
    }

    public void addChild(Human human, Human child) {
        List<Human> childNewFather = new ArrayList<>();

        if (human.getChildren() != null) {
            for (Human chil : human.getChildren()) {
                childNewFather.add(chil);
            }
        }

        childNewFather.add(child);
        human.setChildren(childNewFather);
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setSpouse(Human spouse) {
        if (this.spouse == null || !this.spouse.equals(spouse)) {
            this.spouse = spouse;
        }
        
        if (spouse.getSpouse() == null || !spouse.getSpouse().equals(this)) {
            spouse.setSpouse(this);
        }
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }
    
    public String getFIOtoString() {
        return this.lastName + " " + this.name + " " + this.secondName;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getParentFather() {
        return parentFather;
    }

    public Human getParentMother() {
        return parentMother;
    }

    public int getGeneration() {
        return generation;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getSpouse() {
        return spouse;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }
}