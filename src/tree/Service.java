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

    public Human findHuman(String name) {
        for (Human human : tree) {
            if (human.getName().equals(name)) return human;
        }
        return null;
    }

     public void sortByName() {
        tree.sortByName();
     }

     public void sortByChild() {
        tree.sortByChild();
     }

     @Override
     public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : tree) {
            stringBuilder.append(String.format("%s, (детей: %d)\n",
                    human.getParent(),
                    human.getChildrenList().size()));
        }
        return stringBuilder.toString();
     }
}
