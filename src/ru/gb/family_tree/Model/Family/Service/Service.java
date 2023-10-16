package ru.gb.family_tree.Model.Family.Service;

import ru.gb.family_tree.Model.Family.Tree.CreationTreeHuman;
import ru.gb.family_tree.Model.Family.Tree.FamilyTree;
import ru.gb.family_tree.Model.Family.Service.writer.FileHandler;

public class Service{
    private FamilyTree familyTree;
    public Service() {
        familyTree = CreationTreeHuman.addTree();
    }
    public void saverTree(){
        SaverReader.save(familyTree);
    }
    public FamilyTree readFile(){
        familyTree = SaverReader.read();
        return familyTree;
    }
    public String sortInfoTree(){
        return familyTree.toString();
    }
    public void sortByAge() {
        familyTree.sortByAge();
    }
    public void sortByDateOfBirth() {
        familyTree.sortByDateOfBirth();
    }
    public void sortByGender() {
        familyTree.sortByGender();
    }
    public void sortByName() {
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

