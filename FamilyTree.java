package FT;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> tree;


    public FamilyTree() {
        tree = new ArrayList<>();
    }
    public void addHuman(Human human) {
        tree.add(human);
    }

    public Human findByName(String name) {
        for (Human human: tree) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        for (Human human: tree) {
            stringbuilder.append(human + "\n");
        }
        return stringbuilder.toString();
    }
}
