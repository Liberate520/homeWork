package presenter;


import model.Service.Service;
import model.creature.Creature;
import model.creature.Gender;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
    }

    public void addCreature(String name, Gender gender, LocalDate dataBirth) {
        service.addCreature(name, gender, dataBirth);
    }
    public void sortByName() {
        service.sortByName();
        getCreatureListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getCreatureListInfo();
    }

    public void getCreatureListInfo() {
        String answer = service.getCreatureListInfo();
        view.printAnswer(answer);
    }
}
