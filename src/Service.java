import family_tree.FamilyTree;
import family_tree.FamilyTreeItem;
import human.Human;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(Human human) {
        familyTree.addHuman(human);
    }

    public String printHumanList() {
        StringBuilder sb = new StringBuilder();
        for (FamilyTreeItem human : familyTree) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByFirstName() {
        familyTree.sortByFirstName();
    }

    public void sortByLastName() {
        familyTree.sortByLastName();
    }

    public void sortByChildrenCount() {
        familyTree.sortByChildrenCount();
    }
}
