package presenter;

import java.time.LocalDate;

import model.Gender;
import model.Human;
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
        addHuman(name, surname, dateOfBirth, null, null, gender);
        receiveInformation();
    }

    public void addHuman(String name, String surname, LocalDate dateOfBirth, Human mother, Human father,
            Gender gender) {
        service.addHuman(name, surname, dateOfBirth, mother, father, gender);
        receiveInformation();
    }

    public void receiveInformation() {
        String information = service.getInformation(); // запрос в service и получение ответа в переменную information
        view.print(information); // вывод через метод print во View (Console)
    }

    public void sortByAge() {
        service.sortByAge();
        receiveInformation();
    }

    public void sortByBirthdate() {
        service.sortByBirthdate();
        receiveInformation();

    }

    public void sortByName() {
        service.sortByName();
        receiveInformation();

    }

    public void writeFile(String path) {

        service.writeService(path);
    }

    public void readFile(String path) {

        String dataRead = "Прочитанные данные:\n" + service.readService(path);
        view.print(dataRead);
        
    }
    

}
