package presenter;

import model.Gender;
import model.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(int id, String name, Gender gender, LocalDate birthday) {
        service.addHuman(id, name, gender, birthday);
        getAllHuman();
    }

    public void getAllHuman() {
        String info = service.getAllHuman();
        view.printAnswer(info);
    }

    public void sortByBirthDay() {
        service.sortByBirthDay();
        getAllHuman();
    }

    public void sortByName() {
        service.sortByName();
        getAllHuman();
    }
}
