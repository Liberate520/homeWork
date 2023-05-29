package java_oop_homeWork.src.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

public class FamilyTreesForWrite implements Serializable, Iterable<FamilyTree> {
    public TreeSet<FamilyTree> familyTrees;
    public int idLastPerson;

    public FamilyTreesForWrite(TreeSet familyTrees, int id) {
        this.familyTrees = familyTrees;
        this.idLastPerson = id;
    }

    public FamilyTreesForWrite() {
        this.familyTrees = new TreeSet<>();
        this.idLastPerson = 0;
    }

    @Override
    public Iterator iterator() {
        return familyTrees.iterator();
    }
}
