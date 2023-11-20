package presenter;

import model.Service;
import model.human.Gender;
import view.View;

public class Presenter {
    private View view;
    private Service service;

public Presenter(View view) {
    this.view = view;
    service = new Service();
    }
public void addHuman(String name, String surname, Gender gender) {
        service.addHuman(name, surname, gender);
        //
        getHumansListInfo();
    }

    public void getHumansListInfo() {
        String info = service.getHumansListInfo();
        view.printAnswer(info);
    }

    public void sortByName() {
        service.sortByName();
        getHumansListInfo();
    }

    public void sortBySurname() {
        service.sortBySurname();
        getHumansListInfo();
    }

    public void load() {
        service.load();
    }

    public void write() {
        service.write();
    }

}