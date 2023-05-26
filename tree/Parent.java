package homeWork.tree;


import java.time.LocalDate;
import java.util.ArrayList;

public class Parent extends Human {
    private ArrayList<Human> children;

    public Parent(String name, String gender, LocalDate birthday, Boolean alive, Boolean childfree) {
        super(name, gender, birthday, alive, childfree);
        children = new ArrayList<>();
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void addChild(Human human) {
        this.children.add(human);
    }

    @Override
    public String toString() {
        return this.getName() + " " + children;
    }
}