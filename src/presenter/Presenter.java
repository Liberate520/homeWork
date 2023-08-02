package presenter;

import model.person.Person;
import model.service.Service;
import view.View;

public class Presenter {
    private View view;
    private Service<Person> service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service<>();
    }

    public void addPerson (Person person) {
        service.addPerson(person);
    }
}
