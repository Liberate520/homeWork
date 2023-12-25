package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.familytree.FamilyTree;
import ru.gb.family_tree.model.human.HumanBuilder;
import ru.gb.family_tree.model.writer.Writable;

import java.time.LocalDate;

public class Service {
    private Writable writable;
    private FamilyTree<Human> familyTree;
    private HumanBuilder builder;

    public Service() {
        familyTree = new FamilyTree<>();
        builder = new HumanBuilder();
    }

    public String addHuman(String name, Gender gender, LocalDate birthDate) {
        Human human = builder.build(name, gender, birthDate);
        familyTree.addSub(human);
        return name;
    }

    public String getByName(String name){
        StringBuilder sb = new StringBuilder();
        for (Human human:
                familyTree.getByName(name)) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    public boolean setWedding(long humanId1, long humanId2){
        Human human1 = familyTree.getByID(humanId1);
        Human human2= familyTree.getByID(humanId2);
        return familyTree.setWedding(human1, human2);
    }

    public boolean setDivorce(long humanId1, long humanId2){
        Human human1 = familyTree.getByID(humanId1);
        Human human2 = familyTree.getByID(humanId2);
        return familyTree.setDivorce(human1, human2);
    }

    public boolean setParent(long parentId, long childId){
        Human parent = familyTree.getByID(parentId);
        Human child = familyTree.getByID(childId);
        return familyTree.setParent(parent, child);
    }

    public boolean setChild(long childId, long parentId){
        Human child = familyTree.getByID(childId);
        Human parent = familyTree.getByID(parentId);
        return familyTree.setChild(child, parent);
    }

    public void remove(long id) {
        familyTree.remove(id);
    }

    public boolean saveFile() {
        if (writable == null) {
            return false;
        }
        return writable.saveFile(familyTree, "tree.out");
    }

    public boolean readFile() {
        if (writable == null) {
            return false;
        }
        return true;
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public String getHumanList() {
        return familyTree.getInfo();
    }
}
