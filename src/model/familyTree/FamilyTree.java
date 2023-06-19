package model.familyTree;

import model.Predicate;
import model.comparators.AgeComparator;
import model.comparators.ChildComparator;
import model.comparators.NameComparator;
import model.human.TreeMember;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree<T extends TreeMember> implements Serializable, Iterable<T>{
    private final List<T> family;

    public FamilyTree() {
        family = new ArrayList<>();
    }

    public void addMember(T member) {
        if (!contains(member)) {
            family.add(member);
            if (member.getFather() != null) {
                member.getFather().addChild(member);
            }
            if (member.getMother() != null) {
                member.getMother().addChild(member);
            }
        }
    }

    private Boolean contains(T search) {
        for (T member : family) {
            if (member.equals(search)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T member : family) {
            builder.append(member);
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(family);
    }

    public void sortByName() {
        family.sort(new NameComparator<>());
    }

    public void sortByBirthday() {
        family.sort(new AgeComparator<>());
    }

    public void sortByChildrenAmount() {
        family.sort(new ChildComparator<>());
    }

    public List<T> getMembers(Predicate predicate) {
        return family.stream().filter(predicate::isEqual).collect(Collectors.toList());
    }
}
