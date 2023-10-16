package ru.gb.family_tree.Model.Family.Service;

import ru.gb.family_tree.Model.Family.Service.writer.FileHandler;
import ru.gb.family_tree.Model.Family.Tree.FamilyTree;

public class SaverReader {
    private static FileHandler fileHandler;
    private FamilyTree familyTree;

    public SaverReader() {
        fileHandler = new FileHandler();
        this.familyTree = new FamilyTree<>();
    }
    public static void save(FamilyTree familyTree) {
        fileHandler.save(familyTree);
    }
    public static FamilyTree read(){
        FamilyTree familyTree = (FamilyTree) fileHandler.read();
        return familyTree;
    }
}
