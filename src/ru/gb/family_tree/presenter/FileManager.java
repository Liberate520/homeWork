package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.servise.FileHandler;
import ru.gb.family_tree.model.servise.TestData;
import ru.gb.family_tree.model.tree.FamilyTree;

import java.io.IOException;

public class FileManager {
    private FamilyTree familyTree;
    private FileHandler fileHandler;

    public FileManager() {
        familyTree = TestData.testData();
        fileHandler = new FileHandler();;
    }

    public void saveInFile(){
        fileHandler.save(familyTree, "src/ru/gb/family_tree/tree.out");
        System.out.println("экспорт (tree.out) завершен успешно");
    }
    public void loadFromFile(){
        FamilyTree familyTree = (FamilyTree) fileHandler.loading("src/ru/gb/family_tree/tree.out");
        System.out.println("Импорт данных выполнен  >>>>>>  " + familyTree);
    }
}
