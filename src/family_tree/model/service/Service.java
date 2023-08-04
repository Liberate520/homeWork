package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;

import java.time.LocalDate;

public class Service {
    private int idHuman;
    private FamilyTree<Human> tree;

    public Service() {
        tree = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate birthData) {
        Human human = new Human(name, gender, birthData);
        tree.add(human);
        System.out.println(name + " добавлена");
    }

    public String getHumanInfo() {
        return tree.getInfo();
    }

    public void wedding(long idHusband, long idWife) {
        tree.setWedding(idHusband, idWife);
        System.out.println("Супруг(а) добавлены");
    }

    public void addChildren(long idChildren, long idFather, long idMother) {

        Human child = tree.getById(idChildren);
        Human father = tree.getById(idFather);
        Human mother = tree.getById(idMother);
        if (child != null && father != null && mother != null) {
            father.addChild(child);
            mother.addChild(child);
            child.addParent(father);
            child.addParent(mother);
            System.out.println("Ребенок " + child.getName() + " добавлен");
        } else {
            System.out.println("id не найден");
        }
    }

    public void addParent(long idChildren, long idFather, long idMother) {
        Human child = tree.getById(idChildren);
        Human father = tree.getById(idFather);
        Human mother = tree.getById(idMother);
        if (child != null && father != null && mother != null) {
            father.addChild(child);
            mother.addChild(child);
            child.addParent(father);
            child.addParent(mother);
            System.out.println("Родители " + father.getName() + " и " + mother.getName() + " добавлены");
        } else {
            System.out.println("id не найден");
        }
    }

    public void setTree(FamilyTree<Human> tree) {
        this.tree = tree;

    }

    public FamilyTree<Human> getTree() {
        return tree;
    }

}
