package homeWork.ProjectFamilyTree.Model.Services;

import homeWork.ProjectFamilyTree.Model.Family_tree;
import homeWork.ProjectFamilyTree.Model.FileHandler;
import homeWork.ProjectFamilyTree.Model.Human;

import java.io.IOException;

public class SaveObject {
    private static Family_tree<Human> familyTree;

    public SaveObject() {
        familyTree = new Family_tree<>();
    }
    private static FileHandler fileHandler = new FileHandler();
    public static void Save() throws IOException {fileHandler.Save(familyTree);}
}
