package ru.gb.f_tree.services;

import ru.gb.f_tree.builder.HumanBuilder;
import ru.gb.f_tree.human.Gender;
import ru.gb.f_tree.human.Human;
import ru.gb.f_tree.f_tree.FamilyTree;

public class FamilyTreeService {
    private FamilyTree tree;
    private HumanBuilder builder;
    private String familyName;

    public FamilyTreeService(String familyName) {
        this.familyName = familyName;
        tree = new FamilyTree(familyName);
        builder = new HumanBuilder();
    }

    public Human addNewToFamily(String lastname, String name, Gender gender) {
        Human human = builder.build(lastname, name, gender);
        tree.addMember(human);
        return human;
    }
    public String getInfoShort () {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья " + familyName + ": \n");
        for (Human member: tree) {
            stringBuilder.append(member);
            if (member.getAge() == 0) {
                stringBuilder.append(", возраст неизвестен\n");
            }
            else {
                stringBuilder.append(", возраст: ").append(member.getAge()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void sortFamilyMembersByFullName(){
        tree.sortFamilyMembersByFullName();
    }

    public void sortFamilyMembersByAge(){
        tree.sortFamilyMembersByAge();
    }

    public void sortFamilyMembersById() {
        tree.sortFamilyMembersById();
    }
    @Override
    public String toString() {
        return getInfoShort();
    }
}
