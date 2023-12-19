package model.service;

import model.exception.HumanExcistsException;
import model.human.Gender;
import model.human.Human;
import model.tree.FamilyTree;
import model.writer.Writable;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Service {
    private int id;
    private FamilyTree<Human> familyTree;
    private Writable writable;


    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, String lastName, Gender gender) throws HumanExcistsException {
        Human human = new Human(name, lastName, gender);
        familyTree.addMembers(human);
    }

    public String getFamilyInfo() {
        return familyTree.getFamilyInfo();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void load() throws IOException {
        familyTree = (FamilyTree) writable.read("output.data");
    }

    public boolean save() {
        return writable.save(familyTree, "output.data");
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public String infoByID(int id) {
        return familyTree.infoById(id);
    }

    public boolean setBirthday(int id, int year, int month, int day) {
        Human human = familyTree.findInTree(id);
        if (human != null) {
            human.setBirthday(checkDate(year, month, day));
        }
        return human.getBirthday() != null;
    }
    public boolean setDeathdate(int id, int year, int month, int day) {
        Human human = familyTree.findInTree(id);
        if (human != null) {
            human.setDeathday(checkDate(year, month, day));
        }
        return human.getDeathday() != null;
    }
    public void addSpouse(int one, int two) {
        Human first = familyTree.findInTree(one);
        Human second = familyTree.findInTree(two);
        first.setSpouse(second);
        second.setSpouse(first);
    }
    public void addChild(int parentId, int childId) {
        Human parent = familyTree.findInTree(parentId);
        Human child = familyTree.findInTree(childId);
        parent.setChild(child);
        child.setParent(parent);
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
    public boolean checkId(int id) {
        Human human = familyTree.findInTree(id);
        return human != null;
    }
}


