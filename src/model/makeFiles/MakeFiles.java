package model.makeFiles;

import model.famyilyTree.FamilyTree;

public interface MakeFiles {
    boolean saveToFile (FamilyTree tree, String filename);
    FamilyTree readFromFile(String filename);
}
