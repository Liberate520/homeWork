package Dogs;

import famalyTree.FamilyTreeItems;
import humans.Gender;

import java.util.ArrayList;
import java.util.List;

public class Dog implements FamilyTreeItems {

    private Gender gender;
    private String firstName;
    private Dog mother;
    private Dog father;
    private List<Dog> children;


    public Dog(Gender gender, String firstName, Dog mother, Dog father) {
        this.gender = gender;
        this.firstName = firstName;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Dog(Gender gender, String firstName) {
        this(gender, firstName, null, null);
    }

    public void name(String name) {
        this.firstName = name;
    }

    public void setMother(Dog mother) {
        this.mother = mother;
    }

    public void setFather(Dog father) {
        this.father = father;
    }


    public Gender getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public Dog getMother() {
        return mother;
    }

    public Dog getFather() {
        return father;
    }

    public List<Dog> getChildren() {
        return children;
    }

    public void addChild (Dog child) {
        children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String motherName;
        String fatherName;
        if(mother == null) {motherName = "неизвестно";}
        else {motherName = mother.getFirstName();}
        if(father == null) {fatherName = "неизвестно";}
        else {fatherName = father.getFirstName();}
        sb.append("Гендер: ");
        sb.append(gender);
        sb.append(", Имя: ");
        sb.append(firstName);
        sb.append(", Мать: ");
        sb.append(motherName);
        sb.append(", Отец: ");
        sb.append(fatherName);
        sb.append(", Дети: ");
        sb.append(this.getChildrenName());
        return sb.toString();
    }

    public String getChildrenName(){
        StringBuilder sb = new StringBuilder();
        if(children.size() == 0) {
            sb.append("нет детей");
        } else {
            for (Dog dog : children) {
                sb.append(dog.getFirstName());
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}

