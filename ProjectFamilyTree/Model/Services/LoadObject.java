package homeWork.ProjectFamilyTree.Model.Services;

import homeWork.ProjectFamilyTree.Model.Family_tree;
import homeWork.ProjectFamilyTree.Model.FileHandler;
import homeWork.ProjectFamilyTree.Model.Human;

import java.io.IOException;

public class LoadObject {
    private Family_tree<Human> familyTree;

    public LoadObject() {
        familyTree = new Family_tree<>();
    }
    private static FileHandler fileHandler = new FileHandler();
    public static void Load() throws IOException, ClassNotFoundException {fileHandler.Load();}
}
