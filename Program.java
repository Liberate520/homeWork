
import human.Human;
import model.saveFile.FileHandler;
import model.saveFile.Writable;
import model.service.Service;
import model.tree.FamilyTree;
import presenter.Presenter;
import ui.Console;

import ui.View;


public class Program {

  public static void main(String[] args) {

    FamilyTree<Human> tree = new FamilyTree<>();
    View view = new Console();
    Writable writable = new FileHandler();
    Service service = new Service(tree,writable);
    Presenter presenter = new Presenter(view, service);
    view.start();

  }
}