package presentor;

import model.people.Gender;
import model.service.Service;
import view.View;
import java.time.LocalDate;

public class Presentor {
    private final View view;
    private final Service service;

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
    public boolean indexHumanTrue(int indexHuman) {
        return service.indexHumanTrue(indexHuman);
    }
    public boolean saveHumanList() {
        return service.saveHumanList();
    }
    public void loadHumanList() {
        service.loadHumanList();
    }
    public void getHumanFullInfo(int humanIndex) {view.printAnswer(service.getHumanFullInfo(humanIndex));}
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
