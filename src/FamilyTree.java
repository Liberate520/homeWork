import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyTree = new ArrayList<Human>();

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }
    public  FamilyTree()
    {
        this(new ArrayList<>());
    }

    public List<Human> getFamilyTree() {
        return familyTree;
    }

    public void setFamily(List<Human> familyTree) {
        this.familyTree = familyTree;
    }
    public void addMember(Human newHuman) {
        this.familyTree.add(newHuman);
    }
    public void addMember(List<Human> newHuman) {
        this.familyTree.addAll(newHuman);
    }
    @Override
    public String toString() {
        return familyTree.toString();
    }

    public void getChildren(List<Human> familyTree) {
        this.familyTree = familyTree;
    }
}


