package ru.gb.f_tree.f_tree;

import java.io.Serializable;
import java.util.*;
import ru.gb.f_tree.comparators.*;
import ru.gb.f_tree.f_mem.FamilyMember;
import ru.gb.f_tree.human.Ageble;
import ru.gb.f_tree.human.Human;
import ru.gb.f_tree.human.Idable;
import ru.gb.f_tree.human.Nameble;

public class FamilyTree<T extends FamilyMember & Idable & Ageble & Nameble> implements Serializable, Iterable<Human> {
    private final List<T> familyMembers;
    private final Comparator<T> ageComparator = new AgeComparator<>();
    private final Comparator<T> idComparator = new IdComparator<>();
    private final Comparator<T> fullNameComparator = new FullNameComparator<>();

    public FamilyTree(String familyName) {
        this.familyMembers = new ArrayList<>();
    }

    public void addMember(T familyMember) {
        familyMembers.add(familyMember);
    }

    public List<T> getAllMembers() {
        return familyMembers;
    }

    public List<T> getFamilyMembers() {
        return familyMembers;
    }

    public List<T> getChildrenOf(T parent) {
        List<T> children = new ArrayList<>();
        for (T familyMember : familyMembers) {
            if (familyMember.getParents().contains(parent)) {
                children.add(familyMember);
            }
        }
        return children;
    }

    public List<T> getSiblingsOf(T person) {
        List<T> siblings = new ArrayList<>();
        List<FamilyMember> parents = person.getParents();
        for (T familyMember : familyMembers) {
            if (!familyMember.equals(person) && new HashSet<>(familyMember.getParents()).containsAll(parents)) {
                siblings.add(familyMember);
            }
        }
        return siblings;
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator();
    }

    public <T extends FamilyMember> void sortFamilyMembers() {
    }
}