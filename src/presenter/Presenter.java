package presenter;

import view.View;
import model.FamilyTreeService;
import java.time.LocalDate;

public class Presenter {
    private final View view;
    private final FamilyTreeService service;

    public Presenter(View view, FamilyTreeService service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void showTree(){
        String info = service.toString();
        view.print(info);
    }

    public void addHuman(String name, String surname, LocalDate dayOfBirth) {
        service.addHuman(name, surname, dayOfBirth);
    }

    public void sortName() {
        service.sortByName();
        service.showWithIter();
    }

    public void sortDate() {
        service.sortByDateOfBirht();
        service.showWithIter();
    }

    public void search(String surname, String name) {
        service.search(surname, name);
    }

    public void load() {
        service.read();
    }

    public void save() {
        service.save();
    }
}
