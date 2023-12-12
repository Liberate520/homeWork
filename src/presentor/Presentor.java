package presentor;

import model.human.Gender;
import model.human.Human;
import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presentor {
    private View view;
    private Service service;
    public Presentor(View view) {
        this.view = view;
        service = new Service();
    }

    public boolean humanDeath(int humanIndex, LocalDate deathDate) {
        return service.humanDeath(humanIndex, deathDate);
    }
    public boolean addHuman(String name, String familyName, Gender gender, LocalDate birthData, int indexMother, int indexFather) {
        return service.addHuman(name, familyName, gender, birthData, indexMother, indexFather);
    }

    public void getFamilyTree(int humanIndex) {
        view.printAnswer(service.getFamilyTree(humanIndex));
    }
    public void getFamily(int humanIndex) {
        view.printAnswer(service.getFamily(humanIndex));
    }
    public void getAllHumans() {
        view.printAnswer(service.getAllHumans());
    }
    public void getMan() {
        view.printAnswer(service.getMan());
    }
    public void getWoman() {
        view.printAnswer(service.getWoman());
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByFamilyName() {
        service.sortByFamilyName();
    }
}
