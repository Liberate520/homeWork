import Model.FamilyTree.FamilyTree;
import Model.FamilyTreeObject.Humans.Human;
import Model.FamilyTreeService;
import Presenter.Presenter;
import View.View;
import View.ViewConsole;

public class Main {
    public static void main(String[] args) {
        View view = new ViewConsole();
        FamilyTreeService<FamilyTree> familyTreeService = new FamilyTreeService();
        Presenter presenter = new Presenter(familyTreeService, view);

        view.start();


    }
}
