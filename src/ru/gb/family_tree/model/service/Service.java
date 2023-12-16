package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.comparator.TreeNode;
import ru.gb.family_tree.model.gender.Gender;
import ru.gb.family_tree.model.subject.human.Human;
import ru.gb.family_tree.model.familytree.FamilyTree;
import ru.gb.family_tree.model.writer.Writable;

import java.time.LocalDate;

public class Service<E extends TreeNode<E>> {
    private Writable writable;
    private FamilyTree<E> activeTree;

    public Service(FamilyTree<E> activeTree) {
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
        E father = activeTree.getByID(idFather);
        E mother = activeTree.getByID(idMother);
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        // Непонятно, что ставить вместо new Human
        E sub = new Human(name, gender, humanBirthDate, father, mother);
        activeTree.addSub(sub);
        return "Successfully added to the tree";
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
