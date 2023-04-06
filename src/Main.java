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

        human1.setMother(human2);
        human1.setFather(human3);
        human6.setFather(human3);
        human6.setMother(human2);
        human2.setMother(human5);
        human3.setFather(human4);

        Tree<Human> famailytree = new FamilyTree<>();

        famailytree.addpeople(human1, human2, human3);
        famailytree.addpeople(human2, human5, null);
        famailytree.addpeople(human6, human2, human3);
        famailytree.addpeople(human3, null, human4);
        famailytree.addpeople(human4, null, null);
        famailytree.addpeople(human5, null, null);

        OutInput<Human> saveload = new Slfamailytree<>();
        saveload.save(famailytree);
        View<Human> view = new ConsoleUi<>();
        Service<Human> service = new TreeService<>();
        Presenter<Human> presenter = new Presenter<>(view, service);
        int num = 0;
        while (num != 6)
            num = view.start();
    }
}