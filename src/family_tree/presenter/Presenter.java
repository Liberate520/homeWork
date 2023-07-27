package family_tree.presenter;

import family_tree.model.human.Gender;

import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service = new Service();


    public Presenter(View view) {
        this.view = view;

    }

    public void getInfo() {
        view.printAnswer(service.getInfo());

    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        service.addHuman(name, gender, birthDate);
        getInfo();

    }

    public void sortByName() {
        service.sortByName();
        getInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getInfo();
    }
}
