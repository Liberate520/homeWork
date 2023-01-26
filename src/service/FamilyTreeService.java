package service;

import entity.*;
import familytree.*;
import write.*;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeService implements Service {

    private List<FamilyTree> familyTrees = new ArrayList<>();
    private int familyTreeIndex = 0;

    private List<Writable> writers = new ArrayList<>();

    public FamilyTreeService(FamilyTree familyTree) {
        addFamilyTree(familyTree);

        writers.add(new FileHandler());
        writers.add(new StreamHandler());
    }

    @Override
    public void addFamilyTree(FamilyTree familyTree) {
        this.familyTrees.add(familyTree);
    }

    @Override
    public Mammal getMember(String name) {
        return familyTrees.get(familyTreeIndex).getMemberByName(name);
    }

    @Override
    public FamilyTree getTree() {
        return familyTrees.get(familyTreeIndex);
    }

    @Override
    public FamilyTree getTree(int index) {
        familyTreeIndex = index;
        return getTree();
    }

    @Override
    public List<String> getTreeNames() {
        List<String> Trees = new ArrayList<>();

        for (int i = 0; i < familyTrees.size(); i++) {
            Trees.add(familyTrees.get(i).getName());
        }
        return Trees;
    }

    @Override
    public void sortTree(int sortType) {
        if (sortType == 0)
            familyTrees.get(familyTreeIndex).sortById();
        else if (sortType == 1)
            familyTrees.get(familyTreeIndex).sortByName();
        else if (sortType == 2)
            familyTrees.get(familyTreeIndex).sortByChildrenCountDesc();

    }

    @Override
    public List<String> getWriterDescriptions() {
        List<String> descriptions = new ArrayList<>();

        for (int i = 0; i < writers.size(); i++) {
            descriptions.add(writers.get(i).fileTypeDescription());
        }
        return descriptions;
    }

    @Override
    public int getFileType(int writerIndex)
    {
        return writers.get(writerIndex).fileType();
    }

    @Override
    public String saveTree(int fileType) {

        FamilyTree familyTree = familyTrees.get(familyTreeIndex);

        if (familyTree.getMemberList().size() > 0) {

            Writable writer = null;
            for (int i = 0; i < writers.size(); i++) {
                if (writers.get(i).fileType() == fileType) {
                    writer = writers.get(i);
                    break;
                }
            }

            writer.defineFileName(familyTree.getMemberList().get(0).getClass().getSimpleName() + familyTree.getClass().getSimpleName());
            writer.save(familyTree);
            return "Family tree save to " + writer.fileName();
        }
        else return "Family tree has no members to save it in file";
    }

    @Override
    public String loadTree(int fileType) {

        FamilyTree familyTree = familyTrees.get(familyTreeIndex);

        Writable writer = null;
        for (int i = 0; i < writers.size(); i++) {
            if (writers.get(i).fileType() == fileType) {
                writer = writers.get(i);
                break;
            }
        }

        writer.defineFileName(familyTree.getMemberList().get(0).getClass().getSimpleName() +  familyTree.getClass().getSimpleName());

        FamilyTree loadTree = writer.load();
        if (loadTree != null) {
            familyTree.setMemberList(loadTree.getMemberList());
            return "Family tree load from " + writer.fileName();
        }
        else return "Family tree don't load from " + writer.fileName();
    }
}