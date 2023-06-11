import model.familyTrees.FamilyTree;
import model.fileManage.FileManager;
import model.members.Member;
import view.ConsoleUI;
import view.View;

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
//
//        filePathRuriks.saveFile(ruriks); //Сохранение в файл .bin
//        ruriks = filePathRuriks.loadFile(); //Загрузка из файла .bin
//
//        filePathSkywalkers.saveFile(skywalkers);
//        skywalkers = filePathSkywalkers.loadFile();


        View view = new ConsoleUI();
        view.start();
//        System.out.println(ruriks.getParents("Святослав", 972));
    }
}
