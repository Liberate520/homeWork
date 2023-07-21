package tree;
import java.util.ArrayList;
import java.util.List;

class Parent extends Person {
    public List<Person> children;

    public Parent(String n, char g, String d) {
        super(n, g, d);
        children = new ArrayList<>();
    }

    public void addChild(Person c) {
        children.add(c);
    }
}