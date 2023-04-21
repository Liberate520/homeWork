package src;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {

    private HashSet<Human> tree;
    

    public FamilyTree(HashSet<Human> tree) {
        this.tree = tree;
    }

    public FamilyTree() {
        this(new HashSet<>());
    }

    public HashSet<Human> getTree() {
        return tree;
    }

    public void addHuman(Human husband, Human wife, Human child) {

        husband.addChildren(child);
        wife.addChildren(child);
        child.setFather(husband);
        child.setMother(wife);
        tree.add(wife);
        tree.add(husband);
        tree.add(child);
    }

    public boolean add(Human human) {
        tree.add(human);
        if (human == null) {
            return false;
        }
        if (human.getFather() != null) {
            human.getFather().addChildren(human);
        }
        if (human.getMother() != null) {
            human.getMother().addChildren(human);
        }
        return true;
    }

    public Human getByName(String name) {
        for (Human human : tree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public void getInfo() {
        for (Human string : tree) {
            System.out.println(string.getInfo());
        }
    }

    @Override
    public Iterator<Human> iterator() {
        return tree.iterator();
    }
    
}