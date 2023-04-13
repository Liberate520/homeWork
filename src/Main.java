
import group.FamilyTree;
import group.Groupable;
import person.Person;
import presenter.Presenter;
import service.Service;
import view.Console;
import view.View;


public class Main {
    public static void main(String[] args) {
        Groupable<Person> familyTree = new FamilyTree<>();
        View view = new Console();
        Service service = new Service(familyTree);
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}