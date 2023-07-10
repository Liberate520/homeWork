package familyTree.src.family_tree.family_tree1;

import familyTree.src.family_tree.human.comparators.HumanComparatorByBirthDate;
import familyTree.src.family_tree.human.comparators.HumanComparatorByName;
import java.time.LocalDate;
import java.time.Period;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E>{
    private List<E> humanList;
    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(E human){
        for (E parent: human.getParents()){
            addToChildren(human);
        }
    }
    private void addToChildren(E human){
        for (E child: human.getChildren()){
            addToParents(human);
        }
    }
    public E getByDocId(String docId) {
        for (E human: humanList) {
            if (human.getDocId().equals(docId)){
                return human;
            }
        }
        return null;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByBirthDate() {
        humanList.sort(new HumanComparatorByBirthDate());
    }
}
