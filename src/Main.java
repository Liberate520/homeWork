import FileManage.FileManager;

import java.io.File;
import java.util.Arrays;

import static FamilyTrees.Trees.ruriks;

/**
 * Реализовать интерфейс Iterable для дерева.
 * Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
 */

public class Main {
    public static void main(String[] args) {


        FileManager fileHandler = new FileManager(String.join(File.separator, Arrays.asList("data", "ruriksTree.bin")));

        fileHandler.saveFile(ruriks); //Сохранение в файл .bin

        ruriks = fileHandler.loadFile(); //Загрузка из файла .bin

        ruriks.showFamilyTree(); // Отображение древа


    }
}
