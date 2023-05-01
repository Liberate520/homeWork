import Model.FamilyTree.FamilyTree;
import Presenter.Presenter;
import View.View;
import View.ViewConsole;

public class Main {
    public static void main(String[] args) {
        View view = new ViewConsole();
        FamilyTree familyTreeHuman = new FamilyTree();
        Presenter presenter = new Presenter(familyTreeHuman, view);

        view.start();


    }
}
