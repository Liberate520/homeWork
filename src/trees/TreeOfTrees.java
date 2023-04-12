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
        this.getFamilyTrees().add(fTree);
    }

    @Override
    public List<E> getFamilyTrees() {
        return this.fTrees;
    }

    @Override
    public Iterator<E> iterator() {
        return new FTreeIterator(fTrees);
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
            result.append("Members of family " + fTree.getName() + " :");
            result.append(fTree.printAllInfo());
        }
        return result.toString();
    }

    public void printTrees() {
        for (E fTree : getFamilyTrees()) {
            fTree.printTree();
        }
    }

    public void save(Writable<TreeOfTrees<E>> writable, String fileName) {
        writable.save(this, fileName);
    }
}