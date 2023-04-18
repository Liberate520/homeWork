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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human:familyTree){
            sb.append(human.toString());
            sb.append("\n");
        }
        return "Генеалогическоге дерево: \n" + sb;
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
