package ru.gb.family_tree.Model.Family.Service;

import ru.gb.family_tree.Model.Family.Tree.CreationTreeHuman;
import ru.gb.family_tree.Model.Family.Tree.FamilyTree;
import ru.gb.family_tree.Model.Family.Service.writer.FileHandler;

public class Service{
    private FamilyTree familyTree;
    private FileHandler fileHandler;
    public Service() {
        familyTree = CreationTreeHuman.addTree();
        fileHandler = new FileHandler();
    }
    public void saverTree(){
        FamilyTree ft = CreationTreeHuman.addTree();
        fileHandler.save(ft);
    }
    public FamilyTree readFile(){
        FamilyTree tree = (FamilyTree) fileHandler.read();
        return tree;
    }
    public String getInfoTree(){
        return familyTree.toString();
    }
    public void getByAge() {
        familyTree.sortByAge();
    }
    public void getByDateOfBirth() {
        familyTree.sortByDateOfBirth();
    }
    public void getByGender() {
        familyTree.sortByGender();
    }
    public void getByName() {
        familyTree.sortByName();
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FamilyInfo:\n");
        for (Object human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}

