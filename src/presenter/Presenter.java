package presenter;

import UI.View;
import main.Service;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public boolean addNewHuman(String lastname, String firstname, String patronymic,
                               String gender, String fatherName, String motherName) {
        return service.addNewHuman(lastname, firstname, patronymic, gender, fatherName, motherName);
    }

    public void findHuman(String lastname, String firstname) {
        view.print(service.findHuman(lastname, firstname));
    }

    public void printTree() {
        view.print(service.printTree());
    }

    public void save() {
        service.save();
    }

    public void load() {
        service.load();
    }
}