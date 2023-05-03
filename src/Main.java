import model.family.FamilyTree;
import model.Service;

import model.person.Person;
import presenter.Presenter;
import ui.Console;
import ui.View;

public class Main {
    public static void main(String[] args) {

        FamilyTree<Person> testFamily = new FamilyTree<>();
        Service<Person> service = new Service<>(testFamily);

        View view = new Console();
        Presenter presenter = new Presenter(view, service);
        view.setPresenter(presenter);
        view.start();
    }
}