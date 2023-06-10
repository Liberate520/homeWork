package tree.model;

import tree.familyTree.FamilyTree;
import tree.familyTree.Tree;
import tree.handler.FileHandler;
import tree.handler.SaveReadable;
import tree.human.Gender;
import tree.human.Human;

import java.io.IOException;

public class Service {

    private Tree<Human> tree;
    private SaveReadable fileHandler;

    public Service(Tree<Human> tree) {
        fileHandler = new FileHandler();
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
            stringBuilder.append(String.format("%s %s, (детей: %d)\n",
                    human.getName(),
                    human.getParent(),
                    human.getChildrenList().size()));
        }
        return stringBuilder.toString();
     }

     public void saveObject() throws IOException {
        fileHandler.saveObject(tree);
     }

    public void loadFile() throws IOException, ClassNotFoundException {
        tree = (FamilyTree) fileHandler.loadObject();
    }

    public void addChild(String human, String child) {
        findHuman(human).addChild(findHuman(child));
    }
}
