import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    Human human;
    List<Human> FamilyTree;

    public FamilyTree() {
        FamilyTree = new ArrayList<>();
    }

    void addHumanInTree(Human human){
        FamilyTree.add(human);
    }

    public List<Human> getFamilyTree() {
        return FamilyTree;
    }

    public void setFamilyTree(List<Human> familyTree) {
        FamilyTree = familyTree;
    }

    @Override
    public String toString() {
        return "" + FamilyTree;
    }
}
