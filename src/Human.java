import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Human {
    String sex;
    String firsName;
    String lastName;

    Human mother;
    Human father;
    List<Human> children;

    public Human(String sex, String firsName, String lastName, Human mother, Human father, List<Human> children) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.sex = sex;
    }

    public Human(String sex, String firstName, String lastName) {
        this(sex, firstName, lastName, null, null, new ArrayList<>());
    }

    public Human(String sex) {
        this(sex, "No name", "No family", null, null, new ArrayList<>());
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public String getFullName() {
        return this.firsName + " " + this.lastName + " ";
    }

    public String getChildrenNames() {
        StringBuilder names = new StringBuilder();
        for (Human child : this.children) {
            names.append(child.getFullName());
        }
        return names.toString();
    }

    @Override
    public String toString() {
        return firsName +" " + lastName + ". Дети: " + this.getChildrenNames();
    }
}
