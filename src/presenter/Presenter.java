package presenter;

import java.time.LocalDate;

import model.human.Gender;
import model.service.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, int age, LocalDate birthDate) {
        service.addHuman(name, gender, age, birthDate);
        getTreeInfo();
    }

    public void getHumanList() {
        view.print(service.getTreeInfo());
    }

    public void getTreeInfo() {
        String info = service.getTreeInfo();
        view.print(info);
    }

    public void saveTree() {
        service.save();
    }

    public void openSaveTree() {
        service.read();
    }

    public void sortByAge() {
        service.sortByAge();
        getTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getTreeInfo();
    }
}