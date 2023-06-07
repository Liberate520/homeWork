import familyTrees.console_view.FamilyTreeView;
import fileManage.FileManager;
import human.Human;

import java.nio.file.Paths;

import static familyTrees.FamilyTreesArchive.ruriks;

/**
 * Реализовать интерфейс Iterable для дерева.
 * Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
 */

public class Main {
    public static void main(String[] args) {
        FileManager filePath = new FileManager(Paths.get("data","ruriksTree.bin"));
        filePath.saveFile(ruriks); //Сохранение в файл .bin
        ruriks = filePath.loadFile(); //Загрузка из файла .bin


        FamilyTreeView ruriksView = new FamilyTreeView(ruriks);

        ruriksView.sortByDateBirth();
        ruriksView.showFamilyTree();
    }
}
