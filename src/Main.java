import familyTree.FamilyTree;
import familyTree.Service;
import familyTree.member.Human;
import presenter.Presenter;
import service.FileHandler;
import ui.ConsoleUI;
import ui.View;

public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI();
        FamilyTree<Human> tree = new FamilyTree<>();
        Service service = new Service(tree);
        new Presenter(view, service);
        view.start();





    }
}
