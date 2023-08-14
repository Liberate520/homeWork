package FamilyTree.Tree;


import FamilyTree.Tree.model.HumanGroup.Service;
import FamilyTree.Tree.presenter.Presenter;
import FamilyTree.Tree.view.ConsoleUI;
import FamilyTree.Tree.view.View;



public class Main {



    private static String path;
    public static void main(String[] args)  {

        View view = new ConsoleUI();
        Service service = new Service();
        Presenter presenter = new Presenter(view, service);


        view.start(path, service,presenter);
    }

}