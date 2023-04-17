import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Human mother;
    private Human father;
    private List<Human> children = new ArrayList<>();
    
    public Human(String name) {
        this.name = name;
    }

    public void addChild(Human human) {
        children.add(human);
    }

    public void showChildren() {
        System.out.println(children.toString());
    }

    public String toString() {
        return "Имя: " + name;
    }
}
