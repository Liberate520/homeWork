import java.util.ArrayList;
import java.util.List;

public class Parent extends Human{
    List<Human> child;

    public Parent(String name, int age) {
        super(name, age);
        child = new ArrayList<>();
    }


    public void addChildren(Human human) {
        child.add(human);
    }

    @Override
    public List<Human> getChild() {
        return child;
    }
}
