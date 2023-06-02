import ui.View;
import ui.Console;

import java.io.*;
import model.Service;
import model.human.Human;
import model.tree.FamilyTree;
import presenter.Presenter;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
 
        FamilyTree<Human> familyTree = new FamilyTree<>();      

        View view = new Console();
        Service service = new Service(familyTree);
        //service.setWritable(new FileHandler());
        new Presenter(view, service);
        view.start();

    }
}
