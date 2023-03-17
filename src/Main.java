import java.io.FileNotFoundException;
import java.io.IOException;

import familyTreeModel.FamilyTreeService;
import familyTreeModel.FileHandler;
import familyTreeModel.Handler;
import familyTreeModel.Human;
import familyTreeModel.Service;
import ui.View;
import ui.ConsoleUI;
import ui.DesktopUI;
import presenter.Presenter;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        Handler handler = new FileHandler();
        Service service = new FamilyTreeService(handler);
        Presenter presenter = new Presenter(view, service);

        view.start();
    }
}