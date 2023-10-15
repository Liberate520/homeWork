package ru.gb.family_tree.tree;

import ru.gb.family_tree.HumanExcistsException;
import ru.gb.family_tree.human.Human;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyTree {

    private String family;
    public Set<Human> familyMembers;
    int memberId = 1; // хочу нумерацию людей с 1

    public FamilyTree(String family) {
        this.family = family;
        familyMembers = new HashSet<>();
    }

    public void tryAdd (Human human) throws HumanExcistsException {
        if (!familyMembers.add(human)) {
               throw new HumanExcistsException("Такой человек уже есть!");
        }
    }
    public void addMember (Human human) {
        human.setId(memberId++);
        try {
            tryAdd(human);
        } catch (HumanExcistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public String allMembers () {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья " + family + ": \n");
        for (Human member: familyMembers) {
            stringBuilder.append(member).append("\n");
        }
        return stringBuilder.toString();
    }
}

