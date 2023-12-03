package ru.medved_sa.tree_family.model.service;

import ru.medved_sa.tree_family.model.familyTree.FamilyTree;
import ru.medved_sa.tree_family.model.human.Gender;
import ru.medved_sa.tree_family.model.human.Human;
import ru.medved_sa.tree_family.model.save.Writable;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private FamilyTree<Human> activeTree;
    private Writable<FamilyTree<Human>> writable;

    public Service(Writable<FamilyTree<Human>> writable) {
        this.writable = writable;
        activeTree = new FamilyTree<>();
    }


    public boolean saveFile(String filePath) {
        if (writable == null) {
            return false;
        }
        return writable.saveFile(activeTree, filePath);
    }

    public boolean readFile(String filePath) {
        FamilyTree<Human> tempTree;
        if (writable == null) {
            return false;
        }
        tempTree = writable.readFile(filePath);
        activeTree = tempTree;
        return true;
    }

    public String addHuman(String name, String genderString, String birthDate) {
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate);
        activeTree.addHuman(human);
        return "Человек успешно добавлен в дерево";
    }

    public void sortByFirstName() {
        activeTree.sortByFirstName();
    }

    public void sortByAge() {
        activeTree.sortByAge();
    }

    public void sortById() {
        activeTree.sortById();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }

    public boolean setParent(int person_id, int parent_id) {
        if (activeTree.checkId(person_id) && activeTree.checkId(parent_id)) {
            Human human = activeTree.getById(person_id);
            human.addParent(activeTree.getById(parent_id));
            activeTree.getById(parent_id).addChild(human);
            return true;
        }
        return false;
    }

    public boolean checkId(int id) {
        return activeTree.checkId(id);
    }
}
