import java.io.FileNotFoundException;
import java.io.IOException;

import file.OutInput;
import file.Slfamailytree;
import human.Human;
import presenter.Presenter;
import service.Service;
import service.TreeService;
import tree.FamilyTree;
import tree.Tree;
import ui.ConsoleUi;
import ui.View;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Human human1 = new Human("Екатерина", "ж", 1974);
        Human human2 = new Human("Галина", "ж", 1941);
        Human human3 = new Human("Владимир", "м", 1935);
        Human human4 = new Human("Иван", "м", 1905);
        Human human5 = new Human("Евфалия", "ж", 1907);
        Human human6 = new Human("Дарья", "ж", 1976);

        Tree<Human> familytree = new FamilyTree<>();

        familytree.addintree(human1, human2, human3);
        familytree.addintree(human2, human5, null);
        familytree.addintree(human6, human2, human3);
        familytree.addintree(human3, null, human4);
        familytree.addintree(human4, null, null);
        familytree.addintree(human5, null, null);

        OutInput saveload = new Slfamailytree();
        saveload.save(familytree);
        View view = new ConsoleUi();
        Service service = new TreeService((Tree<Human>) saveload.load());
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}