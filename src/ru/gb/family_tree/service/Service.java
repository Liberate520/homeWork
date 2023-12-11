package ru.gb.family_tree.service;


import ru.gb.family_tree.humans.Gender;
import ru.gb.family_tree.humans.Human;
import ru.gb.family_tree.tree.FamilyTree;
import ru.gb.family_tree.writer.Writable;

import java.time.LocalDate;

public class Service {
    private Writable writable;
    private FamilyTree<Human> activeTree;

    public Service(FamilyTree<Human> activeTree) {
        this.activeTree = activeTree;
    }

    public Service() {
        activeTree = new FamilyTree<>();
    }

    public boolean saveFile() {
        if (writable == null) {
            return false;
        }
        return writable.saveFile(activeTree, "tree.out");
    }

    public boolean load() {
        if (writable == null) {
            return false;
        }
        return true;
    }

    public String add(String name, String genderString, String birthDate, long idFather, long idMother) {
        Human father = activeTree.getByID(idFather);
        Human mother = activeTree.getByID(idMother);
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate, father, mother);
        activeTree.addHumans(human);
        return "The human has been successfully added to the tree";
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void sortByName() {
        activeTree.sortByName();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }
}
