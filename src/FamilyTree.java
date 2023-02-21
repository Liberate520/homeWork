import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public Human getByFirstname(String firstname) {
        for (Human human: humanList) {
            if (human.getFirstname().equals(firstname)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder res = new StringBuilder();
        for (Human human: humanList) {
            res.append(human.getFamilyInfo());
            res.append("\n");

        }
        return res.toString();
    }
}
