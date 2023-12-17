package presenter;

import model.creatures.Gender;
import model.service.Service;
import view.ConsoleUI;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private Service service;


    public Presenter() {
        this.service = new Service();
    }

    public String showTree() {
        return service.showTree();
    }

    public boolean addCreature(String firstName, String lastName, Gender gender,
                               LocalDate birthDate) {
        return service.addHuman(firstName, lastName, gender, birthDate);
    }

    public String showHumanTree() {
        return service.showHumanTree();
    }

    public String showNotInTree() {
        return service.showIsNotInTree();
    }

    public String showAll() {
        return service.showAll();
    }

    public boolean setChild(Integer parentID, Integer childID) {
        return service.setChild(parentID, childID);
    }

    public String showAllInfo(Integer id) {
        return service.ShowAllInfo(id);
    }

    public boolean setSpouce(Integer id, Integer id2) {
        return service.setSpouce(id, id2);
    }
}
