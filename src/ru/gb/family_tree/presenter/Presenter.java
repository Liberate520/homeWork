package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service=new Service();
    }
    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender){
        service.addHuman( name, birthDate,  deathDate,gender);
        //view.printAnswer("Добавлен");
        getHumanInfo();

    }


    public void getHumanInfo() {
        String answer=service.getInfo();
        view.printAnswer(answer);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanInfo();
    }
}
