package presenter;

import model.FamilyTree.FamilyTree;
import model.Organisms.Person.OrganismType;
import model.Organisms.Person.Sex;
import model.Service.Service;
import view.UI;

import java.time.LocalDate;

public class Presenter {
    private UI ui;
    private Service service;
    private FamilyTree tree;

    public Presenter(UI ui) {
        this.ui = ui;
        this.service = new Service();
    }

    public void printTree() {
        System.out.println(service.getTree());
    }

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
}
