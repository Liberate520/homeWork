package presenter;

import model.FamilyTree.FamilyTree;
import model.Organisms.Person.OrganismType;
import model.Organisms.Person.Person;
import model.Organisms.Person.Sex;
import model.Service.Service;
import view.UI;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private UI ui;
    private Service service;

    public Presenter(UI ui) {
        this.ui = ui;
        this.service = new Service();
    }

    public List<Person> getTree() {return service.getTree();}
    public void addPerson(OrganismType type, String name, LocalDate birthDate, Sex sex) {
        service.addPerson(type, name, birthDate, sex);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByBirthday();
    }

    public void writeToFile() {
        service.writeToFile();
    }

    public void readFromFile() {
        service.readFromFile();
    }

    private Person getPerson(int index){
        return service.getPerson(index);
    }
    public void setSpouse(int index1, int index2){
        getPerson(index1).setSpouse(getPerson(index2));
        getPerson(index2).setSpouse(getPerson(index1));
    }
    public void setChild(int indexParent, int indexChild){
        getPerson(indexParent).setChild(getPerson(indexChild));
    }
}
