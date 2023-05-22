package familyTree;

import familyTree.model.Service;
import familyTree.model.person.Person;
import familyTree.model.tree.Tree;
import familyTree.presenter.Presenter;
import familyTree.ui.Console;
import familyTree.ui.View;

public class Main {
    public static void main(String[] args) {
        Tree<Person> currentTree = new Tree<>();
        View view = new Console();
        Service service = new Service(currentTree);
        new Presenter(view, service);

        view.start();
    }
}
