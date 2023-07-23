import java.util.ArrayList;
import java.util.List;

class Parent extends Person {
    private List<Person> children;

    public Parent(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }
}