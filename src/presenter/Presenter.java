package presenter;

import model.Service;
import model.humans.Gender;
import ui.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addHuman(String firstName, String lastName, Gender gender, String dateOfBirth) {
        service.addHuman(firstName, lastName, gender, dateOfBirth);
    }

    public void listOfNames() {
        view.print(service.listOfNames());
    }

    public void serchByName(String firstName) {
        view.print(service.searchByName(firstName));
    }


}
