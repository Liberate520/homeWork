package presenter;

import view.View;
import model.FamilyTreeService;
import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private final View view;
    private final FamilyTreeService service;

    public Presenter(View view, FamilyTreeService service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void showTree() {
        view.print(service.showAll());
    }

    public void addHuman(String name, String surname, LocalDate dayOfBirth) {
        service.addHuman(name, surname, dayOfBirth);
    }

    public void sortName() {
        service.sortByName();
    }

    public void sortDate() {
        service.sortByDateOfBirht();
    }

    public List search(String surname, String name) {
        return service.search(surname, name);
    }

    public void load() {
        service.read();
    }

    public void save() {
        service.save();
    }
}
