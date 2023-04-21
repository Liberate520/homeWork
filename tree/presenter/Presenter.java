package presenter;

import java.time.LocalDate;

import ui.View;

import model.ServiceFamilyTree;
import model.essences.Gender;

public class Presenter<E> {
    private View view;
    private ServiceFamilyTree famService;

    public Presenter(View view, ServiceFamilyTree famService) {
        this.view = view;
        this.famService = famService;
        view.setPresenter(this);
    }

    public void saveToFile() {
        famService.saveToFile();
    }

    public String viewFamily() {
        return famService.viewFamily();
    }

    public boolean addCreature(String firstName, String lastName, Gender gender, LocalDate dateBirth) {
        return famService.addCreature(firstName, lastName, gender, dateBirth);
    }

    public void makeChild() {

    }

    public boolean validForChild(String childFirstName, String childLastName, String parentFirstName,
            String parentLastName) {
        return famService.validForChild(childFirstName, childLastName, parentFirstName, parentLastName);
    }

    public boolean readFamilyFromFile() {
        return famService.readFamilyFromFile();
    }

    public boolean writeFamilyToFile() {
        return famService.writeFamilyToFile();
    }

    public String viewInfoByNames(String firstName, String lastName) {
        return famService.viewInfoByNames(firstName, lastName);
    }

}
