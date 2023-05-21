package presenter;

import model.*;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addHuman(String name, int age, String gender, String motherName, String fatherName) {
        service.addHuman(name, age, gender, motherName, fatherName);
    }


    public void showAllRelatives() {
        service.showAllRelatives();
    }

    public String findHumanByName(String name) {
        return service.findHumanByName(name);
    }

    public void showKids(String name) {
        service.showKids(name);
    }

    public void findSiblings(String name) {
        service.findSiblings(name);
    }



}
