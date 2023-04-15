package service;

import service.human.Human;

import java.io.Serializable;

public class Service {
    private  FamilyTree<Human> familyTree;

    private Writable fileHandler;

    public Service() {
        familyTree = new FamilyTree();
        fileHandler = new FileHandler();
    }

    public boolean addMember(String name,String FatherName,String MatherName) {
        Human newHuman =new Human(name,familyTree.find(FatherName),familyTree.find(MatherName));
        return familyTree.addMember(newHuman);
    }

    public String getInfo() {
        return familyTree.getInfo();
    }

    public Human find(String name) {
        return familyTree.find(name);
    }
    public String getChildren(String nameFather)
    {
        return familyTree.find(nameFather).getChildrenInfo();
    }
    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByChild() {
        familyTree.sortByChild();
    }

    public boolean save(String fileName) {
        return fileHandler.save(familyTree, fileName);
    }
    public boolean load(String fileName)
    {
        familyTree=(FamilyTree)fileHandler.load(fileName);
        if(familyTree!=null)
        {
            return true;
        }
        return false;
    }

}

