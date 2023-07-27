package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.model.service.Service;
import family_tree.view.View;


import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void sortByAge() {
    }
    public void getHumanListInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }
    public void addHuman(String firstName, String lastName, LocalDate birthDate, Gender gender) {
        service.addHuman(firstName, lastName, birthDate, gender);
        getHumanListInfo();
    }

    public void sortByDateBirth() {
        service.sortByDateBirth();
        getHumanListInfo();
    }

    public void sortByAgeByFirstName() {
        service.sortByAgeByFirstName();
        getHumanListInfo();
    }

    public void sortByFirstName() {
        service.sortByFirstName();
        getHumanListInfo();
    }

    public void sortByLastName() {
        service.sortByLastName();
        getHumanListInfo();
    }
}
