
import java.io.Serializable;
import java.util.List;

public class Relationship implements Serializable {
    private Person father;
    private Person mother;
    private Person husband;
    private Person wife;
    private List<Person> children;

    public Relationship(Person father, Person mother, Person husband, Person wife, List<Person> children) {
        this.father = father;
        this.mother = mother;
        this.husband = husband;
        this.wife = wife;
        this.children = children;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public Person getHusband() {
        return husband;
    }

    public Person getWife() {
        return wife;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }
}
