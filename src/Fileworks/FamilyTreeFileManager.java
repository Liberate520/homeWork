package Fileworks;

import Model.FamilyMember;
import Model.FamilyTree;
import Model.FamilyTreeSerializable;

import java.io.*;
import java.util.List;

public class FamilyTreeFileManager implements FamilyTreeSerializable {
    private List<FamilyMember> people;

    public FamilyTreeFileManager(List<FamilyMember> people) {
        this.people = people;
    }

    @Override
    public void saveFamilyTree(String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(this);
        }
    }



    public FamilyTree loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            FamilyTree loadedTree = (FamilyTree) inputStream.readObject();
            return loadedTree;
        }
    }




}