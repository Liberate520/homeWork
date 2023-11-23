import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private Human human;
    private List<FamilyTree> heirs;

    public FamilyTree(Human human) {
        this.human = human;
        heirs = new ArrayList<>();
        addHeirs(human);
    }

    private void addHeirs(Human human) {
        List<Human> children = human.getChildrens();
        if (children != null) {
            for (Human child : children) {
                heirs.add(new FamilyTree(child));
            }
        }
    }

    @Override
    public String toString() {
        return human.getName() + " " + human.getFamilyName() +
                " дети: {" + heirs +
                '}';
    }
}
