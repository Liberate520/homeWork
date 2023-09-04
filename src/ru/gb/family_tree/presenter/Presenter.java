package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.model.TreeService;

import java.time.LocalDate;


public class Presenter {
    private View view;
    private TreeService service;
    private int id;

    public Presenter(View view) {
        this.view = view;
        service = new TreeService();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, int age, int id) {
        service.addHuman(name, gender, birthDate, age, id);
        getHumanList();
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }

    public void addChild(String name, Gender gender, LocalDate birthdate, int age, int id) {
        service.addHuman(name, null, null, age, id);
        getHumanList();
    }

    public void addParent(String name, Gender gender, LocalDate birthdate, int age, int id) {
        service.addHuman(name, null, null, age, id);
        getHumanList();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanList();
    }

    public void sortByName() {
        service.sortByName();
        getHumanList();
    }
}
