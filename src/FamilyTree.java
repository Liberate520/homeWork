import java.util.ArrayList;

public class FamilyTree {
    private ArrayList<Human> FamilyTree = new ArrayList<>();

    public ArrayList<Human> getTree() {
        return FamilyTree;
    }

    // Дообавить ребёнка родителю
    public void addChild(Activities parent, Human child) {

    }
    // Дообавить родителя ребёнку
    public void addParent(Activities parent, Human child) {

    }

    // Женить родителей
    public void addVife(Activities vife, Human husband) {

    }
    public void addHusband(Activities husband, Human vife) {

    }

    // Добавить сестру
    public void addSister(Activities sister, Activities brother) {

    }
    // Добавить брата
    public void addBrother(Activities sister, Activities brother) {

    }
    // Добавить дедов
    public void addGrandparent(Activities grandparent, Activities child) {

    }
}
