package ru.gb.family_tree.service;

import ru.gb.family_tree.builder.HumanBuilder;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;

public class Service {
    private FamilyTree tree;
    private HumanBuilder builder;
    private String family;

    public Service(String family) {
        this.family = family;
        tree = new FamilyTree(family);
        builder = new HumanBuilder();
    }

    public Human addNewToFamily(String lastname, String name, Gender gender) {
        Human human = builder.build(lastname, name, gender);
        tree.addMember(human);
        return human;
    }

    public String getInfoShort () {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья " + family + ": \n");
        for (Human member: tree) {
            stringBuilder.append(member);
            if (member.getBirthday() == null) {
                stringBuilder.append(", возраст неизвестен\n");
            }
            else {
                stringBuilder.append(", возраст: ").append(member.age()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public FamilyTree getTree() {
        return tree;
    }

    public void sortByLastname() {
        tree.sortByLastname();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }

    public void sortById() {
        tree.sortById();
    }

    @Override
    public String toString() {
        return getInfoShort();
    }
}
