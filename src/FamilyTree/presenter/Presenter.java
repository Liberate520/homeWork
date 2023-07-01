package FamilyTree.presenter;

import FamilyTree.model.Service;
import FamilyTree.model.person.Gender;
import FamilyTree.model.person.Person;
import FamilyTree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void getFamilyTreeInfo() {
        view.print(service.getFamilyTreeInfo());
    }

    public void getByName(String searchRequest) {
        view.print(service.getByName(searchRequest).getPersonInfo());
    }

    public void addPerson(String name, String inputGender, LocalDate dateOfBirth, String inputMotherName, String inputFatherName) {
        service.createPerson(name, inputGender, dateOfBirth, inputMotherName, inputFatherName);
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void updatePerson(String searchRequest, String name, String inputGender, LocalDate dateOfBirth, String inputMotherName, String inputFatherName) {
        if (name != null) {
            service.getByName(searchRequest).setName(name);;
        }
        if (inputGender != null) {
            service.getByName(name).setGender(Gender.valueOf(inputGender));
        }
        if (dateOfBirth != null) {
            service.getByName(name).setDateOfBirth(dateOfBirth);
        }
        if (inputMotherName != null) {
            service.getByName(name).setMother(service.getByName(inputMotherName));
        }
        if (inputFatherName != null) {
            service.getByName(name).setFather(service.getByName(inputFatherName));
        }
        getByName(name);
    }

    public void saveTree(String path){
        service.saveTree(path);
    }

    public void loadTree(String path) {
        service.loadTree(path);
    }

}
