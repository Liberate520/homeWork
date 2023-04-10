package main;
import human1.Human;
import tree1.FamilyTree;

public class Serviсe {
    private int id;
    private FamilyTree tree;

    public Serviсe(FamilyTree tree) {
        this.tree = tree;
    }

    public FamilyTree getTree() {
        return tree;
    }

    public void addHuman(String name, Human mother, Human father) {
        id++;
        tree.add(new Human(id, name, father.getFather(), mother.getMother()));
    }

    public void sortById() {
        tree.sortById();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void add(Human human) {
    }
    

}
