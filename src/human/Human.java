package human;

import familystructure.familycomparator.FamilyGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyGroup {
    private String firstName;
    private String lastName;
    private Human mother;
    private Human father;
    private List<Human> children;


    public Human(String firstName, String lastName, Human mother, Human father) {
        this.firstName = firstName;
        this.lastName = lastName;
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
    public void addChild(Object child) {
        if (!children.contains(child)){
            children.add((Human) child);
        }
    }
}
