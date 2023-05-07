import model.group.FamilyTree;
import model.group.Groupable;
import model.human.Human;
import presenter.Presenter;
import model.service.Service;
import view.Console;
import view.View;

public class Main {
    public static void main(String[] args) {
        Groupable<Human> familyTree = new FamilyTree<>();
        View view = new Console();
        Service service = new Service(familyTree);
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}       


