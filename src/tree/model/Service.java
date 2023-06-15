package tree.model;

import tree.model.familyTree.FamilyTree;
import tree.model.familyTree.Tree;
import tree.model.handler.FileHandler;
import tree.model.handler.SaveReadable;
import tree.model.human.Gender;
import tree.model.human.Human;

import java.io.IOException;

public class Service {

    private Tree<Human> tree;
    private SaveReadable fileHandler;
    private AddHumanService addHumanService;


    public Service() {
        fileHandler = new FileHandler();
    }

    public Service(Tree<Human> tree) {
        fileHandler = new FileHandler();
        this.tree = tree;
        addHumanService = new AddHumanService(tree.getFamilyTree());
    }

    public void setTree(Tree<Human> tree) {
        this.tree = tree;
    }
    public void setAddHumanService(Tree<Human> tree) {
        addHumanService = new AddHumanService(tree.getFamilyTree());
    }

    public void addHuman(String name, Gender gender, String father, String mother) {
        addHumanService.addHuman(name, gender, father, mother);
    }

    public void addParent(String child, String parent) {
        addHumanService.addParent(child, parent);
    }

    public void findHuman(String name) {
        Human human = addHumanService.findHuman(name);
        if (human != null) System.out.println(human);
        else System.out.println("No human");
    }
    public void removeHumanFromTree(String name) {
        if (addHumanService.removeHumanFromTree(name)) {
            System.out.println(name + " был удален из семейного дерева");
        } else {
            System.out.println(name + " такого нет");
        }
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByChild() {
        tree.sortByChild();
    }

    public void printTree() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : tree) {
            stringBuilder.append(String.format("%s %s, (детей: %d)\n",
                    human.getName(),
                    human.getParent(),
                    human.getChildrenList().size()));
        }
        System.out.println(stringBuilder.toString());
    }

    public void saveObject() throws IOException {
        fileHandler.saveObject(tree);
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        tree = (FamilyTree) fileHandler.loadObject();
    }
}
