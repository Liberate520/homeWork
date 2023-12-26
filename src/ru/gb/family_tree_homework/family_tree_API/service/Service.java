package ru.gb.family_tree_homework.family_tree_API.service;

import ru.gb.family_tree_homework.file_handler.FileHandler;
import ru.gb.family_tree_homework.file_handler.Writable;
import ru.gb.family_tree_homework.family_tree_API.human.builder.HumanBuilder;
import ru.gb.family_tree_homework.family_tree_API.family_tree.FamilyTree;
import ru.gb.family_tree_homework.family_tree_API.human.Gender;
import ru.gb.family_tree_homework.family_tree_API.human.Human;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private HumanBuilder builder;
    private Writable writable;

    public Service() {
        this.familyTree = new FamilyTree<>();
        this.builder = new HumanBuilder();
        this.writable = new FileHandler();
    }

    public void addMember(String name, Gender gender, LocalDate birthDate) {
        Human human = builder.build(name, gender, birthDate);
        familyTree.addFamilyMember(human);
    }

    public Gender getInputGender(String strGender) {
        if (strGender.equals("M") || strGender.equals("F")) {
                switch (strGender) {
                    case "M":
                        return Gender.Male;
                    case "F":
                        return Gender.Female;
                }
            }
        return null;
    }

    public String getFamilyTreeInfo(){
        return familyTree.toString();
    }

    public String getByName(String name){
        return familyTree.getByName(name);
    }

    public boolean setWedding(long humanId1, long humanId2){
        Human human1 = familyTree.getById(humanId1);
        Human human2= familyTree.getById(humanId2);
        return familyTree.setWedding(human1, human2);
    }

    public boolean setDivorce(long humanId1, long humanId2){
        Human human1 = familyTree.getById(humanId1);
        Human human2 = familyTree.getById(humanId2);
        return familyTree.setDivorce(human1, human2);
    }

    public boolean setParent(long parentId, long childId){
        Human parent = familyTree.getById(parentId);
        Human child = familyTree.getById(childId);
        return familyTree.setParent(parent, child);
    }

    public boolean setChild(long childId, long parentId){
        Human child = familyTree.getById(childId);
        Human parent = familyTree.getById(parentId);
        return familyTree.setChild(child, parent);
    }

    public void remove(long id){
        familyTree.remove(id);
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public void sortByBirthDate(){
        familyTree.sortByBirthDate();
    }

    public boolean saveTree(String fileName) {
        return writable.save(familyTree, fileName);
    }

    public boolean loadTree(String fileName) {
        familyTree = (FamilyTree<Human>) writable.read(fileName);
        return familyTree != null;
    }
}
