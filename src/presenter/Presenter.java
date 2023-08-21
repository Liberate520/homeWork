package presenter;

import model.Gender;
import view.View;
import model.Service;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }


    public void addFamily(String name, Gender gender, LocalDate birthday, LocalDate deathday) {
        service.addFamily(name, gender, birthday, deathday);

    }

    public void getFamilysListInfo() {
        String info = service.getInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilysListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilysListInfo();
    }

}
