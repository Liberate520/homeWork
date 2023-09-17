package presenter;

import model.FamilyTree.Tree;
import model.Human.Person;
import model.Service;
import view.View;

import java.io.IOException;
import java.util.List;

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

    public void addParent(long idParent, long idChild) {
        service.addParent(idParent, idChild);
    }

    public void setWedding(long idFirstSpouse, long idSecondSpouse) {
        service.setWedding(idFirstSpouse, idSecondSpouse);
    }

    public void setDevorce(long idFirstSpouse, long idSecondSpouse) {
        service.setDevorce(idFirstSpouse, idSecondSpouse);
    }

    public Tree<Person> getInfo() {
       return service.getActiveTree();
    }

    public void save(String filename) throws IOException {
        service.save(filename);
    }

    public void load(String filename) throws IOException, ClassNotFoundException {
        service.load(filename);
    }

    public List<Person> getSiblings(String sibID) {
        return service.getSiblings(sibID);
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }

    public void removePerson(long idPerson) {
        service.removePerson(idPerson);
    }
}
