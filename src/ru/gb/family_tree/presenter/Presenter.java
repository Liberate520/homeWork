package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.model.TreeService;


public class Presenter {
    private View view;
    private TreeService service;


    public Presenter(View view) {
        this.view = view;
        service = new TreeService();
    }

    public void addHuman(int id, String name, String birthDate, Gender gender, String father, String mother) {
        service.addHuman(id, name, birthDate, gender, father, mother);
    }
    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanList();
    }

    public void sortByName() {
        service.sortByName();
        getHumanList();
    }

    public void ReadFile() {
        service.read();
        getHumanList();
    }

    public void saveToFile() {
        service.write();
    }

}
