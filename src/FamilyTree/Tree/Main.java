package FamilyTree.Tree;



import FamilyTree.Tree.model.FileHander.readSave;
import FamilyTree.Tree.presenter.Presenter;
import FamilyTree.Tree.view.ConsoleUI;
import FamilyTree.Tree.view.View;



public class Main {

    public static void main(String[] args)  {




        View view = new ConsoleUI();
        readSave serialize = new readSave();
        view.start();
        new Presenter(view);

    }

}