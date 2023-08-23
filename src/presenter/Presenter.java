package presenter;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.service.FamilyTreeService;
import view.View;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private FamilyTreeService service;

    public Presenter(View view) {
        service = new FamilyTreeService();
        this.view = view;
    }
    public void setService(FamilyTreeService service) {
        this.service = service;
    }


    public void getHumanList() {
        String answer = service.getHumanList();
        view.printAnswer(answer);
    }

    public void addHuman(String surname, String name, String patronymic, String genderString, String birthDate, String deathDate, long idFather, long idMother) {
        String answer = service.addHuman(surname, name, patronymic, genderString, birthDate, deathDate, idFather, idMother);
        view.printAnswer(answer);
    }

    public void sortByFullName() {
        service.sortByFullName();
        getHumanList();
    }
    public void sortByBirthDate() {
        service.sortByBirthDate();
        getHumanList();
    }
    public void sortByAge() {
        service.sortByAge();
        getHumanList();
    }
}
