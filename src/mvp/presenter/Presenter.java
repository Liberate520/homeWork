package mvp.presenter;

import java.time.LocalDate;

import mvp.model.person.Person;
import mvp.model.service.GeoTreeService;
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
            String nameF,
            String surnameF,
            String patronymicF,
            String nameM,
            String surnameM,
            String patronymicM) {

        service.addPerson(new Person(
                name,
                surname,
                patronymic,
                dateOfBirth,
                service.getByName(nameF, surnameF, patronymicF),
                service.getByName(nameM, surnameM, patronymicM)));

        System.out.println("Добавление члена семьи и его данных");
    }

    public void addNote(
            String name,
            String surname,
            String patronymic,
            LocalDate dateOfBirth) {

        service.addPerson(new Person(
                name,
                surname,
                patronymic,
                dateOfBirth));

        System.out.println("Добавление члена семьи и его данных");
    }

    public void getNote(String text) {
        System.out.println("Получение члена семьи и его данных");
    }

    public void getAllNote() {
        System.out.println("Получение всех родственников и их данных");
    }
}
