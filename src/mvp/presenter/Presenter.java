package mvp.presenter;

import java.time.LocalDate;

import model.person.Person;
import model.service.GeoTreeService;
import mvp.ui.View;

public class Presenter {
    private View view;
    private GeoTreeService service;

    public Presenter(View view, GeoTreeService service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addNote(
            String name,
            String surname,
            String patronymic,
            LocalDate dateOfBirth,
            Person father,
            Person mother) {
        
        service.addPerson(name, surname, patronymic, dateOfBirth, father, mother);

        System.out.println("Добавление члена семьи и его данных");
    }

    public void getNote(String text) {
        System.out.println("Получение члена семьи и его данных");
    }

    public void getAllNote() {
        System.out.println("Получение всех родственников и их данных");
    }
}
