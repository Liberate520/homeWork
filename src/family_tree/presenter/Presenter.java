package family_tree.presenter;

import family_tree.model.human.Gender;

import family_tree.model.service.Service;
import family_tree.view.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();

    }

    public void getInfo() {
        view.printAnswer(service.getInfo());

    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, String nameFather, String nameMother) {
        service.addHuman(name, gender, birthDate, nameFather, nameMother);
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

    public void save(){
        service.save();

    }
    public Object read(){
        service.read();
        return null;
    }

}
