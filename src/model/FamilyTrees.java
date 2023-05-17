package java_oop_homeWork.src.model;

import java_oop_homeWork.src.model.familyTree.FamilyTree;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

public class FamilyTrees implements Serializable, Iterable<FamilyTree> {
    public TreeSet<FamilyTree> familyTrees;
    public int id;

    public FamilyTrees(TreeSet familyTrees, int id) {
        this.familyTrees = familyTrees;
        this.id = id;
    }
    @Override
    public Iterator iterator() {
        return familyTrees.iterator();
    }
}
