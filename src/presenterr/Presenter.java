package presenterr;

import modell.FamilyTreeService;
import vieww.View;

public class Presenter {
    private View view;
    private FamilyTreeService service;

    public Presenter(View view) {
        service = new FamilyTreeService();
        this.view = view;
    }

    public void loadTreeFromFile() {
        view.print("Data loaded from file: ");
        service.load();
    }

    public void saveToFile() {
        view.print("Data saved to file: ");
        service.save();
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }

    public void sortByName() {
        view.print("Sorted tree by name: ");
        service.sortByName();
    }

    public void sortByBirthDate() {
        view.print("Sorted tree by age: ");
        service.sortByBirthDate();
    }
}