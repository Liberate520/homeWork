import Human.Human;
import Services.Service;
import Tree.Tree;
import ui.ConsoleUi;
import ui.View;
import Presenter.Presenter;

import java.io.IOException;

public class Main {
    static Tree<Human> familyTree = new Tree<Human>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUi();
        Service<Human> service = new Service(familyTree);
        new Presenter(view, service);
        view.start();
    }
}
