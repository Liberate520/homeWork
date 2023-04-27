package famalyTree;

import humans.comparators.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItems> implements Serializable, Iterable<E> {
    private List<E> familyMembers;

    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    public List<E> getFamilyMembers() {
        return familyMembers;
    }

    public void addMember(E member) {
        familyMembers.add(member);
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for (E member : familyMembers) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }

    public E searchByName(String firstName) {
        for (E member : this) {
            if (member.getFirstName().equals(firstName)) {
                return member;
            }
        }
        return null;
    }
    public void sortByName(){
        familyMembers.sort(new ComparatorByName<>());
    }

    public void sortAmountOfChildren(){
        familyMembers.sort(new ComparatorByChildren<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(familyMembers);
    }
}