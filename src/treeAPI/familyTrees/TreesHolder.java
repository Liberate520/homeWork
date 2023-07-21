package treeAPI.familyTrees;

import treeAPI.familyTree.FamilyTree;
import treeAPI.handler.Writable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreesHolder<E extends FamilyTree> implements Serializable, InterfaceTrees<E> {
    private List<E> fTrees;

    public TreesHolder() {
        this.fTrees = new ArrayList<>();
    }

    public boolean addFamilyTree(E fTree) {
        return this.getFamilyTrees().add(fTree);
    }

    @Override
    public List<E> getFamilyTrees() {
        return this.fTrees;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorOfTrees(fTrees);
    }

    public E findFamilyTree(String name){
        for (E familyTree : getFamilyTrees()) {
            if (familyTree.getName().equals(name)) {
                return familyTree;
            }
        }
        return null;
    }

    public String printAllInfo() {
        StringBuilder result = new StringBuilder();
        for (E fTree : getFamilyTrees()) {
            result.append("Members of family " + fTree.getName() + " :\n");
            result.append(fTree.printAllInfo());
        }
        return result.toString();
    }

    public String printTrees() {
        StringBuilder result = new StringBuilder();
        for (E fTree : getFamilyTrees()) {
            result.append(fTree.printTree());
        }
        return result.toString();
    }

    public void save(Writable<TreesHolder<E>> writable, String fileName) {
        writable.save(this, fileName);
    }
}
