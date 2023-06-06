package tree;

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
        tree.addHuman(human);
    }
     public void sortByName() {
        tree.sortByName();
     }

     public void sortByChild() {
        tree.sortByChild();
     }
}
