package Model;

import Model.FamilyMember;
import Model.FamilyTree;
import Model.FamilyTreeSerializable;

import java.io.*;

public class FamilyTreeFileManager implements FamilyTreeSerializable<FamilyMember> {

    @Override
    public void saveFamilyTree(FamilyTree<FamilyMember> familyTree, String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<FamilyMember> loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree<FamilyMember>) inputStream.readObject();
        }
    }
}
