package presenter;

import model.Service;
import ui.View;


public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    public boolean addEntry( String name, String gender, String birthYear,
                          String fatherName, String motherName) {
        return service.addEntry(name, gender, birthYear, fatherName, motherName);
    }

    public void showEntry(String name) {
        view.print(service.showEntry(name));
    }

    public void showAllEntries() {
        view.print(service.showAll());
    }

    public boolean deleteEntry(String name) {
        return service.deleteEntry(name);
    }

    public void save() {
        service.save();
    }

    public void load() {
        service.load();
    }
}
