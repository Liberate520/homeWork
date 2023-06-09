package FamilyTree;

import FamilyTree.interfaces.TreeItem;
import FamilyTree.comparators.ChildComparator;
import FamilyTree.comparators.AgeComparator;
import FamilyTree.iterators.TreeIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree<T extends TreeItem> implements Serializable, Iterable<Human> {
    private static final long serialVersionUID = 1L;
    private ArrayList<T> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public boolean addMember(T member) {
        if (humanList.contains(member)) {
            return false;
        } else {
            if (member.getFather() != null) {
                T father = (T) member.getFather();
                father.addChild(member);
            }

            if (member.getMother() != null) {
                T mother = (T) member.getMother();
                mother.addChild(member);
            }

            humanList.add(member);
            return true;
        }
    }

    public ArrayList<T> getFamily() {
        return humanList;
    }

    public void sortByChild(ArrayList<T> collection) {
        collection.sort(new ChildComparator<>());
    }

    public void sortByAge(ArrayList<T> collection) {
        collection.sort(new AgeComparator<>());
    }

    @Override
    public Iterator<Human> iterator() {
        return new TreeIterator(humanList);
    }
}
