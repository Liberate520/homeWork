package presenter1;


import model.FamilyTreeService;
import ui.View;


import java.io.FileNotFoundException;
import java.io.IOException;



public class Presenter {

    private View view;
    private FamilyTreeService familyTreeService;

    public Presenter(View view, FamilyTreeService service) {
        this.view = view;
        this.familyTreeService = service;
        view.setPresenter(this);
    }
    public boolean addEntry( String name, String gender, Integer birthYear,
                          String fatherName, String motherName) {
        return familyTreeService.addEntry(name, gender, birthYear, fatherName, motherName);
    }

    public void showEntry(String name) {
        view.print(familyTreeService.showEntry(name));
    }

    public void showAllEntries() {
        view.print(familyTreeService.showAll());
    }

    

    public void save() throws FileNotFoundException {
        familyTreeService.save();
    }

    public void load() throws FileNotFoundException, IOException {
        familyTreeService.load();
    }
}

// public class Presenter {

// private View view;
// private FamilyTree familyTree;

// public Presenter(View view, FamilyTree<T> familyTree) {
// this.view = view;
// this.familyTree = familyTree;
// view.setPresenter(this);
// }

// public void onClick(String command) {
// if (command == "1") {
// String answer = familyTreeService.getAllHumanToString(command);
// }

// view.print(answer);
// }

// }
