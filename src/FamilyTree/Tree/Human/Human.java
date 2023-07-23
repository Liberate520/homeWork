package FamilyTree.Tree.Human;

import java.util.ArrayList;
import java.util.List;

public class Human {
    protected List<Human> children = new ArrayList<>();

    static protected List<Human> persons;
    protected String surname;
    protected String name;
    protected String patronymic;
    protected String dateOfBirth;
    protected Human parent = null;

    static {
        persons = new ArrayList<>();
    }
    public Human(String surname, String name, String patronymic, String dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.addHuman(this);
    }

    public Human(String surname, String name, String patronymic, String dateOfBirth, Human parent) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.parent = parent;
        parent.addChild(this);
        this.addHuman(this);
    }

    public void addHuman(Human person){
        persons.add(person);
    }

    public static List<Human> getHumans(){
        return persons;
    }

    public List<Human> getChildren(){
        return children;
    }


    public Human getParent(){
        return this.parent;
    }

    public void addChild(Human children){
        this.children.add(children);
    }
    public void setPatronymic(Human parent){
        this.parent = parent;
        parent.addChild(this);
    }

    public String getName(){
        return this.name;
    }

    public String getSurnameName(){
        return this.surname;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    @Override
    public String toString() {
        return " Human: " + surname+ " "  + name + " " + patronymic + ": " + "date of birth: " + dateOfBirth;
    }
}
