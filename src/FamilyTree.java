import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> list;

    public FamilyTree(List<Human> list) {
        this.list = list;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        this.list.add(human);
        return false;
    }

    public List<String> getListChildren(String name, String familyName) {
        List<String> res = new ArrayList<>();
        for (Human human: list) {
            if (name == human.getFatherName() || familyName == human.getLastName()) {
                res.add(String.valueOf(human));
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "list=" + list +
                '}';
    }
}
