import family_tree.FamilyTree;
import human.Human;

public class Service {
    private FamilyTree familyTree;

    public Service() {
        familyTree = new FamilyTree();
    }

    public void addHuman(Human human) {
        familyTree.addHuman(human);
    }

    public String printHumanList() {
        StringBuilder sb = new StringBuilder();
        for (Human human : familyTree) {
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
