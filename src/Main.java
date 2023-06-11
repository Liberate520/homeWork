import model.fileManage.FileManager;
import view.ConsoleUI;
import view.View;

import java.nio.file.Paths;

import static model.familyTrees.FamilyTreesArchive.ruriks;
import static model.familyTrees.FamilyTreesArchive.skywalkers;

/**
 * Реализовать интерфейс Iterable для дерева.
 * Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
 */

public class Main {
    public static void main(String[] args) {
//        FileManager filePathRuriks = new FileManager("data/ruriksTree.bin");
//        FileManager filePathSkywalkers = new FileManager("data/skywalkersTree.bin");
//
//        filePathRuriks.saveFile(ruriks); //Сохранение в файл .bin
//        filePathSkywalkers.saveFile(skywalkers);
//
//        ruriks = filePathRuriks.loadFile(); //Загрузка из файла .bin
//        skywalkers = filePathSkywalkers.loadFile();


        View view = new ConsoleUI();
        view.start();
    }
}
