import ui.View;
import ui.Console;
import ui.Service;

import java.io.*;

import files.FileHandler;
import files.Writable;
import model.human.Human;
import model.tree.FamilyTree;
import presenter.Presenter;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //FileHandler fileHandler = new FileHandler();
        FamilyTree<Human> familyTree = new FamilyTree<>();
        // Presenter presenter = new Presenter(familyTree);
        // Console console = new Console(familyTree, fileHandler, presenter);
        // console.start();

        

        View view = new Console();
        Service service = new Service(familyTree);
        //service.setWritable(new FileHandler());
        new Presenter(view, service);
        view.start();

    }
}
