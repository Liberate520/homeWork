package ru.gb.f_tree.services;

import ru.gb.f_tree.builder.HumanBuilder;
import ru.gb.f_tree.f_mem.FamilyMember;
import ru.gb.f_tree.f_tree.FamilyTree;
import ru.gb.f_tree.human.*;

public class FamilyTreeService<T extends FamilyMember & Idable & Ageble & Nameble> {
    private FamilyTree<T> tree;
    private HumanBuilder builder;
    private String familyName;

    public FamilyTreeService(String familyName) {
        this.familyName = familyName;
        tree = new FamilyTree<>(familyName);
        builder = new HumanBuilder();
    }

    public T addNewToFamily(String lastname, String name, Gender gender) {
        T familyMember = (T) builder.build(lastname, name, gender);
        tree.addMember(familyMember);
        return familyMember;
    }

    public String getInfoShort() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья ").append(familyName).append(": \n");
        for (Human member : tree) {
            stringBuilder.append(member);
            if (member.getAge() == null) {
                stringBuilder.append(", возраст неизвестен\n");
            } else {
                stringBuilder.append(", возраст: ").append(member.getAge()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void sortFamilyMembers() {
        tree.sortFamilyMembers();
    }

    @Override
    public String toString() {
        return getInfoShort();
    }
}
