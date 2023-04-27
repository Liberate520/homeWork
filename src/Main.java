package src;

import java.io.IOException;
import java.lang.module.FindException;
import src.presenter.Presenter;
import src.treeApi.FamilyTree;
import src.treeApi.FileHandler;
import src.treeApi.Service;
import src.ui.ConsoleUi;
import src.ui.View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree familyTree = new FamilyTree();
        Service service = new Service(familyTree);

        // service.add("Nataliya");
        // service.add("Aleksandr");
        // service.add("Svetlana");
        // service.add("Sergey");
        // service.add("Nikita", familyTree.getByName("Sergey"), familyTree.getByName("Svetlana"));
        // service.add("Kseniya", familyTree.getByName("Aleksandr"), familyTree.getByName("Nataliya"));
        // service.add("Miroslava", familyTree.getByName("Nikita"), familyTree.getByName("Kseniya"));


        // for (Object human : service.sortByName()) {
        // System.out.println(human);
        // }
        // System.out.println();
        // System.out.println();

        // for (Object human : service.sortById()) {
        // System.out.println(human);
        // }


        View view = new ConsoleUi();
        Presenter presenter = new Presenter(view, service);
        view.start();
      
    }
}