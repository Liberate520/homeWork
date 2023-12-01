package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.builder.HumanBuilder;
import ru.gb.family_tree.model.exception.HumanExcistsException;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.writer.Writable;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;
    private HumanBuilder builder;
    private Writable writable;

    public Service() {
        tree = new FamilyTree<>();
        builder = new HumanBuilder();
    }

    public Human addNewToFamily(String lastname, String name, Gender gender) throws HumanExcistsException {
        Human human = builder.build(lastname, name, gender);
        tree.addMember(human);
        return human;
    }

    public String infoByID(int id) {
        return tree.infoById(id);
    }

    public boolean setBirthday(int id, int year, int month, int day) {
        Human human = tree.findInTree(id);
        if (human != null) {
            human.setBirthday(checkDate(year, month, day));
        }
        return human.getBirthday() != null;
    }

    private LocalDate checkDate(int year, int month, int day) {
        LocalDate date = null;
        if (dateIsValid(year, month, day)) {
            date = LocalDate.of(year, month, day);
        }
        return date;
    }

    private boolean dateIsValid(int year, int month, int day) {
        try {
            LocalDate date = LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public String getInfoShort() {
        return tree.getInfoShort();
    }

    public void sortByLastname() {
        tree.sortByLastname();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void sortById() {
        tree.sortById();
    }

    @Override
    public String toString() {
        return getInfoShort();
    }

    public boolean setDeathdate(int id, int year, int month, int day) {
        Human human = tree.findInTree(id);
        if (human != null) {
            human.setDeathday(checkDate(year, month, day));
        }
        return human.getDeathday() != null;
    }

    public void addSpouse(int one, int two) {
        Human first = tree.findInTree(one);
        Human second = tree.findInTree(two);
        first.setSpouse(second);
        second.setSpouse(first);
    }

    public void addChild(int parentId, int childId) {
        Human parent = tree.findInTree(parentId);
        Human child = tree.findInTree(childId);
        parent.setChild(child);
        child.setParent(parent);
    }

    public void load() throws IOException {
        tree = (FamilyTree) writable.read("output.data");
    }

    public boolean save() {
        return writable.write(tree, "output.data");
    }

    public boolean checkId(int id) {
        Human human = tree.findInTree(id);
        return human != null;
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }
}
