package ru.gb.f_tree.f_tree;

import ru.gb.f_tree.human.Human;
import ru.gb.f_tree.comparators.AgeComparator;
import ru.gb.f_tree.comparators.IdComparator;
import ru.gb.f_tree.comparators.FullNameComparator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private String familyName;
    private final List<Human> familyMembers;

    public FamilyTree(String familyName) {
        this.familyName = familyName;
        this.familyMembers = new ArrayList<>();
    }

    public void addMember(Human human) {
        familyMembers.add(human);
    }

    public List<Human> getAllMembers() {
        return familyMembers;
    }

    public List<Human> getFamilyMembers() {
        return familyMembers;
    }

    public List<Human> getChildrenOf(Human parent) {
        List<Human> children = new ArrayList<>();
        for (Human member : familyMembers) {
            if (member.getParents().contains(parent)) {
                children.add(member);
            }
        }
        return children;
    }

    public List<Human> getParentsOf(Human child) {
        return child.getParents();
    }

    public List<Human> getSiblingsOf(Human person) {
        List<Human> siblings = new ArrayList<>();
        List<Human> parents = person.getParents();
        for (Human member : familyMembers) {
            if (!member.equals(person) && new HashSet<>(member.getParents()).containsAll(parents)) {
                siblings.add(member);
            }
        }
        return siblings;
    }

    public void sortFamilyMembersByAge() {
        familyMembers.sort(new AgeComparator());
    }

    public void sortFamilyMembersById() {
        familyMembers.sort(new IdComparator());
    }

    public void sortFamilyMembersByFullName() {
        familyMembers.sort(new FullNameComparator());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyMembers);
    }
}
