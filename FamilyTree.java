package FamilyTree;
import java.util.List;
    // Класс, представляющий генеалогическое древо
public class FamilyTree {

    public FamilyTree(Human root) {
        this.root = root;
    }

    public void addFamilyMember(Human parent, Human child) {
        parent.addChild(child);
    }


    public List<Human> getChildrenOfHuman(Human human) {
        return human.getChildren();
    }
}

