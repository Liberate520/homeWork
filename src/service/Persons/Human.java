package service.Persons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human extends Person implements Serializable, InterfaceHuman {
    private String name;
    private int date;
    private Gender gender;
    private Person father;
    private Person mother;
    private ArrayList<Person> children;

    public Human(String name, Gender gender, int date, Person father, Person mother, ArrayList<Person> children) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.father = father;
        this.mother = mother;
        this.children=children;
    }

    public Human() {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }

    public void addChildren(Person person) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(person);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("Имя: ").append(name).append(", ");
        if(gender == Gender.Male)
        {sb.append("пол: мужской").append(", ");}
        else
        {sb.append("пол: женский").append(", ");}
        sb.append("дата смерти: ").append(date).append(", ");
        if(father == null)
        {sb.append("отец неизвестен").append(", ");}
        else
        {sb.append("отец: ").append(father.getName()).append(", ");}
        if(mother == null)
        {sb.append("");}
        else
        {sb.append("мать: ").append(mother.getName()).append(", ");}      
        if (children == null)
        {sb.append("");}
        else
        {
            sb.append("дети: ");
            for (int i =0; i < children.size(); i++)
            {
                sb.append(children.get(i).getName()).append(", ");
            }
        }
        sb.append("\n");
        return sb.toString();
    }
//    @Override
//    public int compareTo(Person person) {
//        return getName().compareTo(person.getName());
//    }
}
