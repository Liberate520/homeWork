package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FamilyTree {

    private HashSet<Human> tree;

    public FamilyTree(HashSet<Human> tree) {
        this.tree = tree;
    }

    public FamilyTree() {
        this(new HashSet());
    }

    public HashSet<Human> getTree() {
        return tree;
    }

    public void addHuman(Human husband, Human wife, Human child) {

        husband.addChildren(child.getName());
        wife.addChildren(child.getName());
        child.setFather(husband);
        child.setMother(wife);
        tree.add(wife);
        tree.add(husband);
        tree.add(child);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return tree.toString();
    }

}