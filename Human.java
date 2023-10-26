package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Human {

    private String name;
    private int birthDate;
    private List<Human> children;

    public Human(String name, int birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public int getBirthDate() {
        return birthDate;
    }
}
