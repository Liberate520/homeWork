package ru.gb.family_tree.tree;

import ru.gb.family_tree.HumanExcistsException;
import ru.gb.family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private String family;
    private List<Human> familyMembers;
    private int memberId = 1; // хочу нумерацию людей с 1

    public FamilyTree(String family) {
        this.family = family;
        familyMembers = new ArrayList<>();
    }

    public void tryAdd (Human human) throws HumanExcistsException {
        if (familyMembers.contains(human)) {
            throw new HumanExcistsException("Такой человек уже есть!");
        }
    }
    public void addMember (Human human) {
        human.setId(memberId++);
        try {
            tryAdd(human);
            if (!familyMembers.contains(human)) {
                familyMembers.add(human);
            }
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

