import tree.FamilyTree;
import tree.comparators.HumanComparatorByDateOfBirth;
import tree.comparators.HumanComparatorByName;

public class Service {
    private FamilyTree tree;
    public Service(FamilyTree tree) {
        this.tree = tree;
    }
    public void sortByName(){
        tree.getTree().sort(new HumanComparatorByName());
    }

    public void sortByDateOfBirht(){
        tree.getTree().sort(new HumanComparatorByDateOfBirth());
    }
}
