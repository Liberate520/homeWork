package Homework.presenter;

import Homework.model.Human.Gender;
import Homework.model.service.Service;
import Homework.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate birth){
        service.addHuman(name, gender, birth);
        getHumanInfo();
    }

    public void getHumanInfo() { view.printAnswer(service.getHumanInfo());}

    public void sortByName() {
        service.sortByName();
        getHumanInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanInfo();
    }

    public void sortByChildren() {
        service.sortByChildren();
        getHumanInfo();
    }

}
