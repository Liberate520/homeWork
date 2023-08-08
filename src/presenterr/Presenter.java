package presenterr;

import modell.FamilyTreeService;
import vieww.View;

public class Presenter {
    private View view;
    private FamilyTreeService service;
    private String filePath = "homeWork_family_tree/output/human_data.ser";

    public Presenter(View view) {
        service = new FamilyTreeService();
        this.view = view;
    }

    public void loadTreeFromFile() {
        service.setWritable(filePath);
        service.load();
        //view.print("Data loaded from file: ");
    }

    public void saveToFile() {
        service.save();
        view.print("Data saved to file: ");
    }

    public void getHumanList() {
        view.print(service.getHumanList());
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