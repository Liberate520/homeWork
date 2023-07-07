package homeWork_OOP_family_tree.infoHuman;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import homeWork_OOP_family_tree.comparatorAndIterator.FamilyIterator;
import homeWork_OOP_family_tree.comparatorAndIterator.NodeComparatorByAge;

import java.util.Iterator;

public class FamilywTree implements Serializable, Iterable<Node>{
    // private long humanId;
    private List<Node> familyList;

    public FamilywTree(List<Node> familyList) {
        this.familyList = familyList;
    }

    public FamilywTree() {
        this.familyList = new ArrayList<>();
    }

    public List<Node> getFamilyList() {
        return familyList;
    }

    public void add(Node human) {
        familyList.add(human);
        // human.people.setId(humanId++);
    }

    public List<Node> searchName(String firstName) {
        List<Node> result = new ArrayList<>();
        for (Node node : familyList) {
            if (node.people.getFirstName() == firstName) {
                result.add(node);
            }
        }
        return result;
    }


    @Override
    public Iterator<Node> iterator() {
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

    public int getAge(Node node) {
        return node.people.age();
    }

    public void sortByName(){
        Collections.sort(familyList);
    }

    public void sortByAge(){
        Collections.sort(familyList, new NodeComparatorByAge());
    }
}