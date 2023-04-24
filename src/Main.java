package src;

import java.io.IOException;
import src.presenter.Presenter;
import src.treeApi.FamilyTree;
import src.treeApi.Service;
import src.ui.ConsoleUi;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree familyTree = new FamilyTree();
        Service service = new Service(familyTree);
        // Human natalia = new Human("Nataliya");
        // Human alexandr = new Human("Aleksandr");
        // Human svetlana = new Human("Svetlana");
        // Human sergey = new Human("Sergey");
        // Human nikita = new Human("Nikita3", sergey, svetlana);
        // Human ksenia = new Human("Kseniya", alexandr, natalia);
        // Human mira = new Human("Miroslava", nikita, ksenia);

        service.add("Nataliya");
        service.add("Aleksandr");
        service.add("Svetlana");
        service.add("Sergey");
        service.add("Nikita", familyTree.getByName("Sergey"), familyTree.getByName("Svetlana"));
        service.add("Kseniya", familyTree.getByName("Aleksandr"), familyTree.getByName("Nataliya"));
        service.add("Miroslava", familyTree.getByName("Nikita"), familyTree.getByName("Kseniya"));

        // FileHandler file = new FileHandler();

        // file.outPut(familyTree);
        // FamilyTree newFamily = file.inPut();

        // newFamily.getInfo();

        
        // for (Object human : service.sortByName()) {
        //     System.out.println(human);
        // }
        // System.out.println();
        // System.out.println();

        // for (Object human : service.sortById()) {
        //     System.out.println(human);
        // }

    
        ConsoleUi view = new ConsoleUi();
        Presenter presenter  = new Presenter(view, service);
        view.start();
    }
}