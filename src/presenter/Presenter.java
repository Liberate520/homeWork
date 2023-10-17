package presenter;

import model.person.Gender;
import model.service.FamilyTreeService;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private FamilyTreeService service;

    public Presenter(View view) {
        this.view = view;
        service = new FamilyTreeService();
    }
    public void getFamilyInfo() {
        String info = service.getFamilyInfo();
        view.printAnswer(info);
    }
    public void createFamilyTree(String familyName) {
        service.createNewFamilyTree(familyName);
    }

    public void createCustomTree() {
        service.createCustomTree();
        getFamilyInfo();
    }

    public void addInFamily(String name, int birthDay, int birthMonth, int birthYear, Gender gender) {
        LocalDate birthDate = LocalDate.of(birthDay, birthMonth, birthYear);
        service.addInFamily(name, birthDate, gender);
        getFamilyInfo();
    }

    public void addDeathDate(int id, LocalDate deathDate) {
        service.addDeathDate(id, deathDate);
        getFamilyInfo();
    }
    public void getMarried(int husbandID, int wifeID) {
        service.getMarried(husbandID, wifeID);
    }
    public void getChild(int childID, int fatherID, int motherID) {
        service.getChild(childID, fatherID, motherID);
    }

    public void getPersonInfo(int id) {
        String info = service.getPersonInfo(id);
        System.out.println(info);
    }
    public void saveFamilyTree() {
        service.saveFamilyTree();
    }
    public void downloadFamilyTree(String name) {
        service.downloadFamilyTree(name);
    }
    public void sortByName() {
        service.sortByName();
        getFamilyInfo();
    }
    public void sortByBirthDate() {
        service.sortByBirthDate();
        getFamilyInfo();
    }
    public int getTreeSize() {
        return service.getTreeSize();
    }
}

