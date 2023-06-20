import model.familyTrees.FamilyTree;
import model.fileManage.FileManager;
import model.members.Member;
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
    }
}
