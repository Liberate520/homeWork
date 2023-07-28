package homeWork;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private int age;
    private List<Human> children;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.children = new ArrayList<>();
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public List<Human> getChildren() {
        return children;
    }

    // Getters for other attributes if needed

    public String getName() {
        return name;
    }
}

