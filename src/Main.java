import model.FamilyTree;
import model.FileHandler;
import model.Service;
import presenter.Presenter;
import view.Console;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler("familyTree", "out");
        FamilyTree<model.Human> familyTree = new FamilyTree<>();
        
        Service service = new Service(familyTree, fileHandler);
        View view = new Console();
        
        Presenter presenter = new Presenter(view, service);
        presenter.createInitialTree();
        
        view.start();
    }
}