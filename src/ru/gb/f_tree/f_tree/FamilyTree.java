package ru.gb.f_tree.f_tree;

import ru.gb.f_tree.human.Human;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FamilyTree {
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
}

