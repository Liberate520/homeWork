package ru.gb.family_tree.service;

import ru.gb.family_tree.builder.HumanBuilder;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;
import ru.gb.family_tree.tree.TreeItem;
import ru.gb.family_tree.writer.FIleHandler;

import java.io.IOException;
import java.time.LocalDate;

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

    public void setBirthday(int id, int year, int month, int day) {
        Human human = tree.findInTree(id);
        human.setBirthday(LocalDate.of(year, month, day));
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

    public void setDeathdate(int id, int year, int month, int day) {
        Human human = tree.findInTree(id);
        human.setDeathday(LocalDate.of(year, month, day));
    }

    public void addSpouse(int one, int two) {
        Human first = tree.findInTree(one);
        Human second = tree.findInTree(two);
        first.setSpouse(second);
    }

    public void addChild(int parentId, int childId) {
        Human parent = tree.findInTree(parentId);
        Human child = tree.findInTree(childId);
        parent.setChild(child);
    }

    public void load() {
        FIleHandler fh = new FIleHandler();
        try {
            tree = (FamilyTree) fh.read("output.data");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save() {
        FIleHandler fh = new FIleHandler();
        if (fh.write(tree, "output.data")) System.out.println("Данные успешно записаны");
    }
}
