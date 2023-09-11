package presenter;

import model.Service;
import view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addPerson(String name, String genderString, String birthYear, String birthMonth, String birthDate, long idFather, long idMother) {
        service.addPerson(name, genderString, birthYear, birthMonth, birthDate, idFather, idMother);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void addChild(long idParent, long idChild) {
        service.addChild(idParent, idChild);
    }

    public void setWedding(long idFirstSpouse, long idSecondSpouse) {
        service.setWedding(idFirstSpouse, idSecondSpouse);
    }

    public void getInfo() {
        service.getInfo();
    }

    public void save(String filename) throws IOException {
        service.save(filename);
    }

    public void load(String filename) throws IOException, ClassNotFoundException {
        service.load(filename);
    }

    public void getSiblings(String sibID) {
        service.getSiblings(sibID);
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }
}
