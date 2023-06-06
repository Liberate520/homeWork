package tree;

import tree.familyTree.TreeItem;
import tree.familyTree.comparators.HumanComparatorByChildCount;
import tree.familyTree.comparators.HumanComparatorByName;
import tree.familyTree.Tree;
import tree.human.Gender;
import tree.human.Human;

public class Service {

    private Tree<Human> tree;

    public Service(Tree<Human> tree) {
        this.tree = tree;
    }

    public void addHuman(String name, Gender gender) {
        Human human = new Human(name, gender);
        tree.setFamily(human);
    }
     public void sortByName() {
        tree.sortByName();
     }

     public void sortByChild() {
        tree.sortByChild();
     }
}
