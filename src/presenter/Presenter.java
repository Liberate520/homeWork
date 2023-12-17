package presenter;

import model.creatures.Gender;
import model.service.Service;

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
        return service.showAllInfo(id);
    }

    public boolean setSpouce(Integer id, Integer id2) {
        return service.setSpouce(id, id2);
    }

    public boolean saveFamilyTree(String filename) {
        return service.save(filename);
    }

    public boolean loadFamilyTree(String filename) {
        return service.load(filename);
    }

    public boolean setDivorce(Integer id, Integer id2) {
        return service.divorce(id, id2);
    }

    public boolean setFather(Integer childId, Integer fatherId) {
        return service.setFather(childId, fatherId);
    }

    public boolean setMother(Integer childId, Integer motherID) {
        return service.setMother(childId, motherID);
    }

    public boolean setDeathDate(Integer humanID, LocalDate date) {
        return service.setDeathDate(humanID, date);
    }
}
