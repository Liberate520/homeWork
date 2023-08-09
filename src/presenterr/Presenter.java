package presenterr;

import java.time.LocalDate;

import modell.FamilyTreeService;
import modell.human.Gender;
import vieww.View;

public class Presenter {
    private View view;
    private FamilyTreeService service;
    //private String filePath = "homeWork_family_tree/output/human_data.ser";

    public Presenter(View view) {
        service = new FamilyTreeService();
        this.view = view;
    }

    public void loadTreeFromFile() {
        service.setWritable();
        service.load();
        //view.print("Data loaded from file!");
    }

    public void saveToFile() {
        service.save();
        view.print("Data saved to file!\n");
    }

    public void getHumanList() {
        view.print(service.getHumanList());
    }

    public void addHuman(String name, Gender userGender, LocalDate birthDate, long idFather, long idMother) {
        service.addHuman(name, userGender, birthDate, idFather, idMother);
    }

    public void removeHuman(long humansId) {
        service.removeHuman(humansId);
    }

    public void sortByName() {
        service.sortByName();
        view.print("Sorted tree by name!\n");
    }

    public void sortByAge() {
        service.sortByBirthDate();
        view.print("Sorted tree by age!\n");
    }
}