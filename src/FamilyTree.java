import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyTree = new ArrayList<Human>();

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public List<Human> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }
    public void addFamilyTree(Human newHuman) {
        this.familyTree.add(newHuman);
    }
    @Override
    public String toString() {
        return familyTree.toString();
    }
}


