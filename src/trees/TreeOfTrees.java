package trees;

import familyTree.FamilyTree;
import handler.Writable;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TreeOfTrees<E extends FamilyTree> implements Serializable, TOTrees<E> {
    private List<E> fTrees;

    public TreeOfTrees() {
        this.fTrees = new ArrayList<>();
    }

    public void addFamilyTree(E fTree) {
        this.fTrees.add(fTree);
    }

    @Override
    public List<E> getFamilyTreeList() {
        return this.fTrees;
    }

    @Override
    public Iterator<E> iterator() {
        return new FTreeIterator(fTrees);
    }

    public E findFamilyTree(String name){
        for (E familyTree : this.fTrees) {
            if (familyTree.getName().equals(name)) {
                return familyTree;
            }
        }
        return null;
    }

    public void printAllInfo() {
        for (E fTree : this.fTrees) {
            System.out.println("Members of family " + fTree.getName() + " :");
            fTree.printInfo();
        }
    }

    public void save(Writable<TreeOfTrees<E>> writable, String fileName) {
        writable.save(this, fileName);
    }
}