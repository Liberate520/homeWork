package familly_api.familytree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import familly_api.human.Node;
import familly_api.human.NodeComparatorByAge;

import java.util.Iterator;

public class FamilywTree<E extends Node> implements Serializable, Iterable<E>{
    private List<E> familyList;

    public FamilywTree(List<E> familyList) {
        this.familyList = familyList;
    }

    public FamilywTree() {
        this.familyList = new ArrayList<>();
    }

    public int getSize() {
        return familyList.size();
    }

    public E getNode(int numberNode){
        return familyList.get(numberNode);
    }

    public List<E> getFamilyList() {
        return familyList;
    }

    public void add(E human) {
        familyList.add(human);
    }

    public List<E> searchName(String firstName) {
        List<E> result = new ArrayList<>();
        for (E node : familyList) {
            if (node.getPeople().getFirstName() == firstName) {
                result.add(node);
            }
        }
        return result;
    }


    @Override
    public Iterator<E> iterator() {
        return new FamilyIterator<>(familyList);

    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        sb.append("в дереве ");
        sb.append(familyList.size());
        sb.append(" объектов: \n");
        for (Node node : familyList) {
            sb.append(node.getPeople().getFirstName());
            sb.append(" " + count++);
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getAge(E node) {
        return node.getPeople().age();
    }

    public void sortByName(){
        Collections.sort(familyList);
    }

    public void sortByAge(){
        Collections.sort(familyList, new NodeComparatorByAge<>());
    }
}