import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    public List<Human> humanList;

    public FamilyTree(List<Human> humenList) {
        this.humanList = humenList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }

    public List<Human> getHumanByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human Human : humanList) {
            if (Human.getName().equals(name)) {
                res.add(Human);
            }
        }
        return res;
    }

    public List<Human> getAllHuman() {
        List<Human> res = new ArrayList<>();
        for (Human Human : humanList) {
            res.add(Human);
        }
        return res;
    }
}
