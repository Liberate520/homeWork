package presenter;

import java.time.LocalDate;

import model.Gender;
import model.Service;
import view.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {

        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String surname, Gender gender, LocalDate dateOfBirth) {
        service.addHumanConsole(name, surname, gender, dateOfBirth);

        receiveInformation();
    }

    public void receiveInformation() {
        String information = service.getInformation(); // запрос в service и получение ответа в переменную information
        view.print(information); // вывод через метод print в View (Console)
    }

    public void sortByAge() {
        service.sortByAge();
        receiveInformation();;
    }

    public void sortByBirthdate() {
        service.sortByBirthdate();
        receiveInformation();

    }

    public void sortByName() {
        service.sortByName();
        receiveInformation();

    }

}
