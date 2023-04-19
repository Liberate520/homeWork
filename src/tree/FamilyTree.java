package tree;

import human.Human;
import human.comparator.HumanComparatorBday;
import human.comparator.HumanComparatorName;
import save.Writable;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class FamilyTree<E extends Human> implements Serializable, Iterable<E>{
   private List<E> familyTree;

    public FamilyTree(List<E> familyTree){
        this.familyTree = familyTree;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public void addFamilyTree( E human) {
        if (!familyTree.contains(human)) {
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            this.familyTree.add(human);
        }
    }
    public Iterator<E> iterator(){
        return new TreeIterator(familyTree);
    }
    public void sortName(){
        familyTree.sort(new HumanComparatorName());
    }
    public void sortbDay(){
        familyTree.sort(new HumanComparatorBday());
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E human: this.familyTree){
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public Human getByName(String name, String surname) {
        for (Human human : this.familyTree) {
            if (human.getName().equals(name) && human.getSurname().equals(surname)) {
                return human;
            }
        }
        return null;
    }
    public boolean deleteHuman(E human){
        return familyTree.remove(human);
    }

}
