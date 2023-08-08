package familytree.presenter;
import java.time.LocalDate;

import familytree.model.human.Gender;
import familytree.model.Service;
import familytree.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {

        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String surname, Gender gender, LocalDate dateOfBirth) {
        service.addHumanConsole(name, surname, gender, dateOfBirth);

        giveInfo();
    }

    public void giveInfo() {
        String information = service.getInform(); 
        view.showInfo(information); 
    }


    public void sortByBirthDate() {
        service.sortByBirthDate();
        giveInfo();

    }

    public void sortBySurname() {
        service.sortBySurname();
        giveInfo();

    }
}
