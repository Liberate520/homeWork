package presenterr;

import java.time.LocalDate;

import modell.FamilyTreeService;
import modell.human.Gender;
import vieww.View;

public class Presenter {
    private View view;
    private FamilyTreeService service;

    public Presenter(View view) {
        service = new FamilyTreeService();
        this.view = view;
    }

    public void loadTreeFromFile() {
        service.setWritable();
        service.load();
    }

    public void saveToFile() {
        service.save();
        view.print("Data saved to file!\n");
    }

    public void getHumanList() {
        view.print(service.getHumanList());
    }

    public void addHuman(String name, Gender userGender, LocalDate birthDate, long idFather, long idMother) {
        service.addHuman(name, userGender, birthDate, idFather, idMother);
    }

    public void removeHuman(long humansId) {
        service.removeHuman(humansId);
    }

    public void setWedding(long humanId1, long humanId2) {
        service.setWedding(humanId1, humanId2);
    }

    public void setDivorce(long humanId1, long humanId2) {
        service.setDivorce(humanId1, humanId2);
    }

    public void sortByName() {
        service.sortByName();
        view.print("Sorted tree by name!\n");
    }

    public void sortByAge() {
        service.sortByBirthDate();
        view.print("Sorted tree by age!\n");
    }
}