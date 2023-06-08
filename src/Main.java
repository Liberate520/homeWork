import familyTrees.console_view.FamilyTreeView;
import fileManage.FileManager;
import members.Aliens;
import members.Human;

import java.nio.file.Paths;

import static familyTrees.FamilyTreesArchive.ruriks;
import static familyTrees.FamilyTreesArchive.skywalkers;

/**
 * Реализовать интерфейс Iterable для дерева.
 * Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
 */

public class Main {
    public static void main(String[] args) {
        FileManager filePathRuriks = new FileManager(Paths.get("data","ruriksTree.bin"));
        FileManager filePathSkywalkers = new FileManager(Paths.get("data","skywalkersTree.bin"));

        filePathRuriks.saveFile(ruriks); //Сохранение в файл .bin
        filePathSkywalkers.saveFile(skywalkers);

        ruriks = filePathRuriks.loadFile(); //Загрузка из файла .bin
//        skywalkers = filePathSkywalkers.loadFile();


        FamilyTreeView<Human> ruriksView = new FamilyTreeView<>(ruriks);

        ruriksView.sortByDateBirth();
        ruriksView.showFamilyTree();

        FamilyTreeView<Aliens> skywalkersView = new FamilyTreeView<>(skywalkers);

        skywalkersView.showFamilyTree();
    }
}
