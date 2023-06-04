package tree;

import tree.familyTree.comparators.HumanComparatorByChildCount;
import tree.familyTree.comparators.HumanComparatorByName;
import tree.familyTree.Tree;
import tree.human.Gender;
import tree.human.Human;

public class Service {

    private Tree tree;

    public Service(Tree tree) {
        this.tree = tree;
    }

    public void addHuman(String name, Gender gender) {
        Human human = new Human(name, gender);
        tree.setFamily(human);
    }
     public void sortByName() {
        tree.getFamilyTree().sort(new HumanComparatorByName());
     }

     public void sortByChild() {
        tree.getFamilyTree().sort(new HumanComparatorByChildCount());
     }
}
