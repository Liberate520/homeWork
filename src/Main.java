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

        View view = new ConsoleUI();
        view.start();


    }

    /**
     * При изменении начинки классов связанных с древом невозможно загрузить данные из файла ruriksTree, в MVP пока
     * не реализовано создание древа с нуля. Поэтому Существует этот метод для обнуления файла силами FamilyTreeArchive
     * Древо будет дорабатываться со временем и этот метод уйдет
     */
    private static void fixBug() {
        FileManager filePathRuriks = new FileManager("data/ruriksTree.bin");
        FileManager filePathSkywalkers = new FileManager("data/skywalkersTree.bin");

        filePathRuriks.saveFile(ruriks); //Сохранение в файл .bin
        ruriks = filePathRuriks.loadFile(); //Загрузка из файла .bin

        filePathSkywalkers.saveFile(skywalkers);
        skywalkers = filePathSkywalkers.loadFile();

    }
}
