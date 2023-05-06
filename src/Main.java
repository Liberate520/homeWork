import java.io.IOException;
import java.util.Scanner;

import model.FamilyTree;
import model.FileHandler;
import model.Human;
import model.Service;
import presenter.Presenter;
import view.Console;
import view.View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    
    FileHandler fileHandler = new FileHandler();
    FamilyTree<Human> familyTree = new FamilyTree<>();
        
    Service service = new Service(familyTree, fileHandler);
    View view = new Console();
    
    Presenter presenter = new Presenter(view, service);
    presenter.createTree();
    
    view.start();
    
    }
}