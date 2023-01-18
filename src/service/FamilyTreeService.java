package service;

import entity.*;
import familytree.*;
import write.*;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeService implements Service {

    private List<FamilyTree> FamilyTrees = new ArrayList<>();
    private int familyTreeIndex = 0;

    public FamilyTreeService(List<FamilyTree> FamilyTrees) {
        this.FamilyTrees = FamilyTrees;
    }

    public FamilyTreeService(FamilyTree familyTree) {
        this.FamilyTrees.add(familyTree);
    }

    @Override
    public void addFamilyTree(FamilyTree familyTree) {
        this.FamilyTrees.add(familyTree);
    }

    @Override
    public Mammal getMember(String name) {
        return FamilyTrees.get(familyTreeIndex).getMemberByName(name);
    }

    @Override
    public FamilyTree getTree() {
        return FamilyTrees.get(familyTreeIndex);
    }

    @Override
    public FamilyTree getTree(int index) {
        familyTreeIndex = index;
        return getTree();
    }

    @Override
    public List<String> getTreeNames() {
        List<String> Trees = new ArrayList<>();

        for (int i = 0; i < FamilyTrees.size(); i++) {
            Trees.add(FamilyTrees.get(i).getName());
        }
        return Trees;
    }

    @Override
    public void sortTree(int sortType) {
        if (sortType == 0)
            FamilyTrees.get(familyTreeIndex).sortById();
        else if (sortType == 1)
            FamilyTrees.get(familyTreeIndex).sortByName();
        else if (sortType == 2)
            FamilyTrees.get(familyTreeIndex).sortByChildrenCountDesc();

    }

    @Override
    public String saveTree(int fileType) {

        FamilyTree familyTree = FamilyTrees.get(familyTreeIndex);

        if (familyTree.getMemberList().size() > 0) {

            String fileName = "";
            if (familyTree.getMemberList().get(0) instanceof Human) fileName = "HumanFamilyTree";
            else if (familyTree.getMemberList().get(0) instanceof Cat) fileName = "CatFamilyTree";

            Writable writer = null;

            if (fileType == 0) {
                fileName += ".txt";
                writer = new FileHandler(fileName);
            }
            else if (fileType == 1) {
                fileName += ".ser";
                writer = new StreamHandler(fileName);
            }

            writer.save(familyTree);
            return "Family tree save to " + fileName;
        }
        else return "Family tree has no members to save it in file";
    }

    @Override
    public String loadTree(int fileType) {

        FamilyTree familyTree = FamilyTrees.get(familyTreeIndex);

        String fileName = "";
        if (familyTree.getMemberList().get(0) instanceof Human) fileName = "HumanFamilyTree";
        else if (familyTree.getMemberList().get(0) instanceof Cat) fileName = "CatFamilyTree";

        Writable writer = null;

        if (fileType == 0) {
            fileName += ".txt";
            writer = new FileHandler(fileName);
        } else if (fileType == 1) {
            fileName += ".ser";
            writer = new StreamHandler(fileName);
        }

        FamilyTree loadTree = writer.load();
        if (loadTree != null) {
            familyTree.setMemberList(loadTree.getMemberList());
            return "Family tree load from " + fileName;
        }
        else return "Family tree don't load from " + fileName;
    }
}