package Model;

import java.io.IOException;

public interface FamilyTreeSerializable<T extends FamilyMember> {
    void saveFamilyTree(FamilyTree<T> familyTree, String fileName) throws IOException;
    FamilyTree<T> loadFamilyTree(String fileName) throws IOException, ClassNotFoundException;
}
