package handler;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import tree.FamilyTree;

public interface FileHandler {
    FamilyTree loadFile(String str);
    void saveFile(FamilyTree familyTree, String str);
}