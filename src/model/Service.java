package model;
import java.io.IOException;

import model.builder.HumanBuilder;
import model.human.Gender;
import model.human.Human;
import model.tree.FamilyTree;
import model.writer.FileHandler;

public class Service {
    public final char[] getHumansListInfo = null;
    private FamilyTree <Human> tree;
    private HumanBuilder builder;
    private FileHandler fileHandler;

    public FamilyTree<Human> getFamilyTree() {
        return this.tree;
    }

    public Service() {
        tree = new FamilyTree<>(0);
        builder = new HumanBuilder();
        fileHandler = new FileHandler();
    }

    public Service(FamilyTree <Human> tree) {
        this.tree = tree;
        builder = new HumanBuilder();
    }

    public String infoByID(int id) {
        return tree.infoById(id);
    }

    public void addHuman(String name, String surname, Gender gender) {
        Human human = builder.build(name, surname, gender);
        tree.addHuman(human);
    }
    public String getHumansListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи: \n");

        for(Human human: tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void addChild(int parentId, int childId) {
        Human parent = tree.findInTree(parentId);
        Human child = tree.findInTree(childId);
        parent.setChild(child);
    }

    public boolean checkId(int id) {
        Human human = tree.findInTree(id);
        return human != null;
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortBySurname() {
        tree.sortBySurname();
    }

    @Override
    public String toString() {
        return getHumansListInfo();
    }

    public void load() throws IOException {
        tree = (FamilyTree) fileHandler.read("output.data");
    }

    public boolean write() {
        return fileHandler.write(tree, "output.data");
    }
}
