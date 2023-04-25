package service;

import human.Human;

import save.LoadUnloadFiles;
import tree.FamilyTree;

import java.util.Scanner;


public class Service {
    private FamilyTree familyTree;
    public Service(FamilyTree familyTree){
        this.familyTree = familyTree;
    }
    public String addHuman(String name, String surname,  String bDay, String fatherName, String fatherSurname, String motherName, String motherSurname)  {
        Human humanFather = getHumanByName(fatherName,fatherSurname);
        Human humanMother = getHumanByName(motherName,motherSurname);
        Human human = new Human(name,surname,bDay,humanFather,humanMother);
        familyTree.addFamilyTree(human);
        return "Человек добавлен";
    }
    public Human getHumanByName(String name, String surname) {
        if (!name.equals("")) {
            return familyTree.getByName(name, surname);
        }
        return null;
    }
    public void deleteHuman(Human human){
        familyTree.deleteHuman(human);
    }
    public String getFamilyTree(){
       return familyTree.toString();
    }
    public String sortByName(){
        familyTree.sortName();
        return familyTree.toString();
    }
    public String sortByBirthday(){
        familyTree.sortbDay();
        return familyTree.toString();
    }
    public String getHuman(String name, String surname){
        Human human = getHumanByName(name,surname);
        return human.toString();
    }
    public boolean saveToFile(){
        LoadUnloadFiles files = new LoadUnloadFiles();
        String fileAddress = "fileTree.out";
        return files.save(familyTree,fileAddress);
    }
    public String readToFile(){
        LoadUnloadFiles files = new LoadUnloadFiles();
        String fileAddress = "fileTree.out";
        FamilyTree<Human> familyFile =  files.read(fileAddress);
        return familyFile.toString();
    }
}
