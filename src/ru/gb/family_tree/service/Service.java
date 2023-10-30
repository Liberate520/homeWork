package ru.gb.family_tree.service;

import ru.gb.family_tree.builder.HumanBuilder;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;
import ru.gb.family_tree.tree.TreeItem;

public class Service {
    private FamilyTree<Human> tree;
    private HumanBuilder builder;
    private String family;

    public Service(String family) {
        this.family = family;
        tree = new FamilyTree<>(family);
        builder = new HumanBuilder();
    }

    public Service() {
        tree = new FamilyTree<>();
        builder = new HumanBuilder();
    }

    public Human addNewToFamily(String lastname, String name, Gender gender) {
        Human human = builder.build(lastname, name, gender);
        tree.addMember(human);
        return human;
    }

    public String infoByID(int id) {
        return tree.infoById(id);
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
