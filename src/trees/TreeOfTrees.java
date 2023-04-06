package trees;

import familyTree.FamilyTree;
import handler.Writable;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TreeOfTrees implements Serializable, TOTrees {
    private List<FamilyTree> fTrees;

    public TreeOfTrees() {
        this.fTrees = new ArrayList<>();
    }

    public void addFamilyTree(FamilyTree fTree) {
        this.fTrees.add(fTree);
    }

    @Override
    public List<FamilyTree> getFamilyTreeList() {
        return this.fTrees;
    }

    @Override
    public Iterator<FamilyTree> iterator() {
        return new FTreeIterator(fTrees);
    }

    public FamilyTree findFamilyTree(String name){
        for (FamilyTree familyTree : this.fTrees) {
            if (familyTree.getName().equals(name)) {
                return familyTree;
            }
        }
        return null;
    }

    public void printAllInfo() {
        for (FamilyTree fTree : this.fTrees) {
            System.out.println("Members of family " + fTree.getName() + " :");
            //System.out.println(fTree.getPersons());
            for (person.Person person : fTree) {
                System.out.println(person);
            }
        }
    }

    public void save(Writable writable, String fileName) {
        writable.save(this, fileName);
    }
}