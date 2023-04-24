package presenter;

import model.FamilyService;
import ui.View;

public class Presenter {
    private FamilyService service;
    private View view;

    public Presenter(FamilyService service, View view) {
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }

    public void addHuman(String name, String gender, String birthDate, String deathDate, String father, String mother) {
        String answerName = service.addHuman(name, gender, birthDate, deathDate, father, mother);
        view.print(answerName);
    }

    public void humanList() {
        String answerList = service.humanList();
        view.print(answerList);
    }

    public void findHuman(String name) {
        String answerFind = service.findHuman(name).toString();
        view.print(answerFind);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }
}
