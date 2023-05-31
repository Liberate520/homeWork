import java.util.ArrayList;
import java.util.List;

public class Parents extends Human {
    private List<Human> children;

    public Parents(String name, String date) {
        super(name, date);
        children = new ArrayList<>();
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void hasChild(Human child) {
        System.out.println(getName() + " - является родителем - " + child.getName());
    }

    @Override
    public void displayFamilyTree() {
        System.out.println(getName() + " (родитель)");

        for (Human child : children) {
            System.out.println("\t" + child.getName() + " (ребенок)");

        }
    }
}
