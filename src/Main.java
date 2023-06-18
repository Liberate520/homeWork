import model.fileManage.FileManager;
import presenter.Presenter;
import view.consoleUI.ConsoleUI;
import view.View;

import static model.familyTrees.FamilyTreesArchive.ruriks;

/**
 * Реализовать интерфейс Iterable для дерева.
 * Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
 */

public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI(new Presenter());
        view.start();
//        fixBug();


    }

    /**
     * При изменении начинки классов связанных с древом невозможно загрузить данные из файла ruriksTree, в MVP пока
     * не реализовано создание древа с нуля. Поэтому Существует этот метод для обнуления файла силами FamilyTreeArchive
     * Древо будет дорабатываться со временем и этот метод уйдет
     */
    private static void fixBug() {
        FileManager filePathRuriks = new FileManager("data/ruriksTree.bin");
        filePathRuriks.saveFile(ruriks); //Сохранение в файл .bin
        ruriks = filePathRuriks.loadFile(); //Загрузка из файла .bin
//        FileManager filePathSkywalkers = new FileManager("data/skywalkersTree.bin");
//        filePathSkywalkers.saveFile(skywalkers);
//        skywalkers = filePathSkywalkers.loadFile();
    }
}
