package familyTree.src.family_tree.family_tree1;

import familyTree.src.family_tree.human.Human;
import familyTree.src.family_tree.human.comparators.HumanComparatorByBirthDate;
import familyTree.src.family_tree.human.comparators.HumanComparatorByName;
import java.time.LocalDate;
import java.time.Period;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human>{
    private List<Human> humanList;
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public boolean add(Human human) {
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

    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }
    public Human getByDocId(String docId) {
        for (Human human: humanList) {
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
        for (Human human: humanList) {
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
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByBirthDate() {
        humanList.sort(new HumanComparatorByBirthDate());
    }
}
