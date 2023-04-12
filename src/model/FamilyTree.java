package model;

import java.io.*;
import java.util.*;


public class FamilyTree <E extends Human> implements Serializable, Iterable<Human> {
    List<E> familyTree;

    public FamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }
    public FamilyTree() {
        this(new ArrayList<E>());
    }

    public void addElement (E element) {
        this.familyTree.add(element);
    }

    public void save (String filepath) throws IOException {
        FileHandler fh = new FileHandler();
        fh.save((Serializable) familyTree, filepath);
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "familyTree=" + familyTree +
                '}';
    }

    public Serializable load (String filepath) throws IOException, ClassNotFoundException {
        FileHandler fh = new FileHandler();
        return fh.load(filepath);

    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator((List<Human>) familyTree);
    }

    public void sortByName () {
        Collections.sort(familyTree);
    }
    public void sortBySex () {
        familyTree.sort(new HumanComparatorBySex());
    }

}
