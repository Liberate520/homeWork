import java.util.ArrayList;
import java.util.List;  
public class FamilyTree {
    private List<Human> humans;
    public FamilyTree() {
        humans = new ArrayList<>();
    }
    public void addHuman(Human human) {
        humans.add(human);
    } 
    public List<Human> getAllChildren(Human parent) {
        List<Human> children = new ArrayList<>();
        for (Human human : humans) {
            if (human.getParents().contains(parent)) {
                children.add(human);
            }
        }
        return children;
    }
}
