package presenter;

import model.creatures.Gender;
import model.service.Service;
import view.View;

import java.time.LocalDate;

//TODO: implement создать интерфейс
public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
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
