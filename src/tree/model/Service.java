package tree.model;

import tree.model.familyTree.FamilyTree;
import tree.model.familyTree.Tree;
import tree.model.handler.FileHandler;
import tree.model.handler.SaveReadable;
import tree.model.human.Gender;
import tree.model.human.Human;
import tree.model.humanService.AddHumanService;
import tree.model.humanService.FindHumanService;
import tree.model.humanService.RemoveHumanService;

import java.io.IOException;

public class Service {

    private Tree<Human> tree;
    private SaveReadable fileHandler;
    private AddHumanService<Human> addHumanService;
    private FindHumanService<Human> findHumanService;
    private RemoveHumanService<Human> removeHumanService;

    public Service() {
        fileHandler = new FileHandler();
    }

    public Service(Tree<Human> tree) {
        fileHandler = new FileHandler();
        this.tree = tree;
        addHumanService = new AddHumanService<>(tree.getFamilyTree());
        removeHumanService = new RemoveHumanService<>(tree.getFamilyTree());
        findHumanService = new FindHumanService<>(tree.getFamilyTree());
    }

    public void setTree(Tree<Human> tree) {
        this.tree = tree;
    }
    public void setAddHumanService(Tree<Human> tree) {
        addHumanService = new AddHumanService<>(tree.getFamilyTree());
    }
    public void setFindHumanService(Tree<Human> tree) { findHumanService = new FindHumanService<>(tree.getFamilyTree()); }
    public void setRemoveHumanService(Tree<Human> tree) { removeHumanService = new RemoveHumanService<>(tree.getFamilyTree()); }

    public void addHuman(String name, Gender gender, String father, String mother) {
        Human human = new Human(name, gender);
        Human dad = findHumanService.findHuman(father);
        Human mom = findHumanService.findHuman(mother);
        addHumanService.addHuman(human);
        if (dad != null) addHumanService.addParent(human, dad);
        else if (!father.isEmpty())human.setFather(new Human(father, Gender.man));
        if (mom != null) addHumanService.addParent(human, mom);
        else if (!mother.isEmpty())human.setMother(new Human(mother, Gender.woman));
    }

    public void addParent(String child, String parent) {
        Human someChild = findHumanService.findHuman(child);
        Human someParent = findHumanService.findHuman(parent);
        if (someChild != null && someParent !=null)
            addHumanService.addParent(someChild, someParent);
        else  {
            System.out.printf("Ребенок %s или Родитель %s отсутствует в дереве\n", child, parent);
        }
    }

    public void findHuman(String name) {
        Human human = findHumanService.findHuman(name);
        if (human != null) System.out.println(human);
        else System.out.println("No human");
    }
    public void removeHumanFromTree(String name) {
        if (removeHumanService.removeHumanFromTree(findHumanService.findHuman(name))) {
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
