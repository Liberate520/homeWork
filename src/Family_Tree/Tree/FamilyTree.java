package Family_Tree.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree <E extends TreeNode<E>> implements Serializable, Iterable<E>{
    private int humanId;
    private List<E> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humanId++);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    public List<E> getHumanList() {
        return humanList;
    }

    public List<E> getByName(String name) {
        List<E> result = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;
    }

    public boolean setWedding(E human1, E human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChildren(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }



    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" людей: \n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        humanList.sort(new FamilyTreeComparatorByName());
    }

    public void sortByBirthday(){
        humanList.sort(new FamilyTreeComparatorByBirthday());
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<E> iterator(){
        return new FamilyTreeIterator(humanList);
    }
}
