package Model.Fileworks;

import Model.Tree.FamilyTree;
import Model.FamilyMember;

import java.io.IOException;

public interface FamilyTreeFileHandler {

    void saveFamilyTree(FamilyTree<FamilyMember> familyTree, String fileName) throws IOException;
    FamilyTree<FamilyMember> loadFamilyTree(String fileName) throws IOException, ClassNotFoundException;
}
