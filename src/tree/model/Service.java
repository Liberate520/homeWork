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
    private AddHumanServis addHumanServis;


    public Service() {
        fileHandler = new FileHandler();
    }

    public Service(Tree<Human> tree) {
        fileHandler = new FileHandler();
        this.tree = tree;
        addHumanServis = new AddHumanServis(tree.getFamilyTree());
    }

    public void setTree(Tree<Human> tree) {
        this.tree = tree;
    }

  /*  public void addHuman(String name, Gender gender, String father, String mother) {
        Human dad;
        Human mom;
        if (!containsHuman(findHuman(father))) {
            dad = new Human(father, Gender.man);
        } else {
            dad = findHuman(father);
        }
        if (!containsHuman(findHuman(mother))) {
            mom = new Human(mother, Gender.woman);
        } else {
            mom = findHuman(mother);
        }
        Human human = new Human(name, gender, dad, mom);
        dad.addChild(human);
        mom.addChild(human);
    }

*/
    public void addHuman(String name, Gender gender, String father, String mother) {
        addHumanServis.createHuman(name, gender, father, mother);
    }

    private boolean containsHumanInTree(Human human) {
        if (containsHuman(human))
            return tree.getFamilyTree().contains(human);
        return false;
    }
    private boolean containsHuman(Human human) {
        return human != null;
    }

    public void findHuman(String name) {
        Human human = addHumanServis.findHuman(name);
        if (human != null) System.out.println(human);
        else System.out.println("No human");
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

    public void addChild(Human human, Human child) {
         human.addChild(child);
    }
}
