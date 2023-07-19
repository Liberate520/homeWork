package module.human;

import module.familystructure.FamilyGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyGroup<Human>, Serializable {
    private String firstName;
    private String lastName;
    private Human mother;
    private Human father;
    private List<Human> children;


    public Human(String firstName, String lastName)
    {
        this(firstName, lastName, null, null);
    }
    public Human(String firstname, String lastname, Human mother, Human father) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public String getLastName() {
        return lastName;
    }

    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }


    @Override
    public String toString() {
        return firstName + " " +  lastName;
    }
    public void addChild(Human child) {
        if (!children.contains(child)){
            children.add(child);
        }
    }
}
