package ru.medved_sa.tree_family.presenter;

import ru.medved_sa.tree_family.model.FamilyTreeService;
import ru.medved_sa.tree_family.view.View;

public class Presenter {
    private View view;
    private FamilyTreeService service;

    public Presenter(View view) {
        this.view = view;
        service = new FamilyTreeService();
    }

    public void addHuman(String name, String gender, String birthDate) {
        String answer = service.addHuman(name, gender, birthDate);
        view.print(answer);
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }

    public void sortByName() {
        service.sortByFirstName();
        getHumanList();

    }

    public void sortByAge() {
        service.sortByAge();
        getHumanList();
    }

    public void readFile() {
        service.readFile();
    }

    public void saveFile() {
        service.saveFile();
    }

}
