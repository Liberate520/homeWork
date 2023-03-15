import java.io.FileNotFoundException;
import java.io.IOException;

import familyTreeModel.FamilyTreeService;
import familyTreeModel.Service;
import ui.View;
import ui.ConsoleUI;
import ui.DesktopUI;
import presenter.Presenter;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
            View view = new ConsoleUI();
            Service service = new FamilyTreeService();
            Presenter presenter = new Presenter(view, service);
    
            view.start();
    }
}