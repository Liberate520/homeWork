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

        OutInput saveload = new Slfamailytree();
        View view = new ConsoleUi();
        Service service = new TreeService((Tree<Human>) saveload.load());
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}