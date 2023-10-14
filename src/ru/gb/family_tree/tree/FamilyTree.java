package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private String family;
    private List<Human> familyMembers;
    int memberId = 1; // хочу нумерацию людей с 1

    public FamilyTree(String family) {
        this.family = family;
        familyMembers = new ArrayList<>();
    }

    public void addMember (Human human) {
        human.setId(memberId++);
        familyMembers.add(human);
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
