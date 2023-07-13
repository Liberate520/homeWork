package homeWork_OOP_family_tree.infoHuman;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import homeWork_OOP_family_tree.comparatorAndIterator.Node;
import homeWork_OOP_family_tree.comparatorAndIterator.NodeComparatorByAge;

import java.util.Iterator;

public class FamilywTree<E extends Node> implements Serializable, Iterable<E>{
    // private long humanId;
    private List<E> familyList;

    public FamilywTree(List<E> familyList) {
        this.familyList = familyList;
    }

    public FamilywTree() {
        this.familyList = new ArrayList<>();
    }

    public List<E> getFamilyList() {
        return familyList;
    }

    public void add(E human) {
        familyList.add(human);
        // human.people.setId(humanId++);
    }

    public List<E> searchName(String firstName) {
        List<E> result = new ArrayList<>();
        for (E node : familyList) {
            if (node.people.getFirstName() == firstName) {
                result.add(node);
            }
        }
        return result;
    }


    @Override
    public Iterator<E> iterator() {
        return new FamilyIterator(familyList);
		// return list.iterator();
        // return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве ");
        sb.append(familyList.size());
        sb.append(" объектов: \n");
        for (Node node : familyList) {
            sb.append(node.people.getFirstName());
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getAge(E node) {
        return node.people.age();
    }

    public void sortByName(){
        Collections.sort(familyList);
    }

    public void sortByAge(){
        Collections.sort(familyList, new NodeComparatorByAge());
    }
}