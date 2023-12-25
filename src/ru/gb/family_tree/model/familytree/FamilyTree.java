package ru.gb.family_tree.model.familytree;

import ru.gb.family_tree.model.comparator.FamilyTreeComparatorByAge;
import ru.gb.family_tree.model.comparator.FamilyTreeComparatorByName;
import ru.gb.family_tree.model.comparator.FamilyTreeIterator;
import ru.gb.family_tree.model.comparator.TreeNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private long subId;
    private List<E> familyTree;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> subList) {
        this.familyTree = subList;
    }

    public boolean addSub(E sub) {
        if (sub == null) {
            return false;
        }
        if (!familyTree.contains(sub)) {
            familyTree.add(sub);
            sub.setId(subId++);

            addParents(sub);
            addChild(sub);

            return true;
        }
        return false;
    }

    private void addParents(E child) {
        for (E parent : child.getParents()) {
            parent.addChild(child);
        }
    }

    private void addChild(E parent) {
        for (E child : parent.getChildren()) {
            child.addParents(parent);
        }
    }

    public int treeSize(){
        return familyTree.size();
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E sub : familyTree) {
            if (sub.getName().equals(name)) {
                res.add(sub);
            }
        }
        return res;
    }

    public boolean remove(long subId) {
        if (checkId(subId)) {
            E e = getByID(subId);
            return familyTree.remove(e);
        }
        return false;
    }

    private boolean checkId(long id) {
        if (id >= subId || id < 0){
            return false;
        }
        for (E sub: familyTree){
            if (sub.getId() == id){
                return true;
            }
        }
        return false;
    }

    public E getByID(long id) {
        for (E sub : familyTree) {
            if (sub.getId() == id) {
                return sub;
            }
        }
        return null;
    }

    public boolean setWedding(E human1, E human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human1.setSpouse(human1);
            return true;
        }
        return false;
    }

    public boolean setDivorce(E human1, E human2){
        if(human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human1.setSpouse(null);
            return true;
        }
        return false;
    }

    public boolean setParent(E parent, E child){
        if (child != null) {
            if (parent.getGender().equals(Gender.Male)) {
                child.setFather(parent);
                return true;
            } else {
                child.setMother(parent);
                return true;
            }
        }
        return false;
    }

    public boolean setChild(E child, E parent) {
        if (parent != null){
            parent.addToChild(child);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("In the tree: ");
        stringBuilder.append(familyTree.size());
        stringBuilder.append(" objects: \n");
        for (E sub : familyTree) {
            stringBuilder.append(sub);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByAge(){
        familyTree.sort(new FamilyTreeComparatorByAge<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(familyTree);
    }
}
