package presenter;

import java.io.Serializable;
import java.time.LocalDate;

import model.FileHandler;
import model.Gender;
import model.Human;
import model.Service;
import view.View;

public class Presenter {

    private View view;
    private Service service;
    private FileHandler fileHandler;

    public Presenter(View view) {

        this.view = view;
        service = new Service();
        fileHandler = new FileHandler();
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

        fileHandler.write(path, service);
    }

    public Serializable readFile(String path) {

        Serializable dataRead = fileHandler.read(path);
        return dataRead;

    }

    

    

}
