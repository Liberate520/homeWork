import java.util.List;

public class FamilyTreeModel {
    private FamilyTree<Human> familyTree;

    public FamilyTreeModel() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(Human human) {
        familyTree.addHuman(human);
    }

    public List<Human> getChildrenOfFather(Human father) {
        return familyTree.getChildrenOfFather(father);
    }

    public List<Human> getChildrenOfMother(Human mother) {
        return familyTree.getChildrenOfMother(mother);
    }

}
