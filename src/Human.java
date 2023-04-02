import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String middleName;
    private String lastName;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, String middleName, String lastName, Human father, Human mother) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
        if (father != null) {
            father.addChild(this);
        }
        if (mother != null) {
            mother.addChild(this);
        }
    }

    private void addChild(Human child) {
        this.children.add(child);
    }

    public String getFullName() {
        if (children.size() > 0) {
            return name + " " + middleName + " " + lastName + ", дети - " + getChildren();
        } else {
            return name + " " + middleName + " " + lastName + ", детeй нет";
        }
    }

    public String getName() {

        return name;
    }

    public String getMiddleName() {

        return middleName;
    }

    public String getLastName() {

        return lastName;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {

        return children;
    }

    @Override
    public String toString() {
        return this.name + " " + this.middleName + " " + this.lastName;
    }

}

