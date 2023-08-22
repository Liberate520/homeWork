package home_work.model.service;

import home_work.model.FamilyTree;
import home_work.model.Gender;
import home_work.model.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private FamilyTree<Human> tree;
    public List<Human> humans;

    public Service() {
        tree = new FamilyTree();
        humans = new ArrayList<>();
    }

    public void createLink(Human parent, Human child) {
        if (!humans.contains(parent)) {
            humans.add(parent);
        }
        if (!humans.contains(child)) {
            humans.add(child);
        }
        parent.addChildren(child);
        child.addParent(parent);
    }

    public void createTree(String name) {
        for (Human human : humans) {
            if (human.getName().contains(name)) {
                tree.createTree(human);
            }
        }
    }

    public void createTree() {
        tree.createTree(humans.get(0));
    }

    public void addHuman(Human human) {
        if (!humans.contains(human)) {
            humans.add(human);
        }
    }

    public String getInfo() {
        return tree.getTree();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public List<Human> getHumanList() {
        return humans;
    }

    public void sortByAge() {
        tree.sortByAge();
    }
}
