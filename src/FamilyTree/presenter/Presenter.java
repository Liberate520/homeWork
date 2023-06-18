package FamilyTree.presenter;

import FamilyTree.model.FamilyTreeService;
import FamilyTree.model.human.Gender;
import FamilyTree.view.View;

import java.time.LocalDate;


public class Presenter {
    private View view;
    private FamilyTreeService service;

    public Presenter(View view, FamilyTreeService service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }
    public void addHuman(String name, Gender gender, LocalDate birthDate,
                         String father, String mother) {
        service.addHuman(name, gender, birthDate, father, mother);
    }
}
