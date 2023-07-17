package family_tree.presenter;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;
import family_tree.model.human.Sex;
import family_tree.model.writer.FileHandler;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public Presenter(View view, FileHandler fileHandler) {
        this.view = view;
        this.fileHandler = fileHandler;
        this.familyTree = new FamilyTree<>();
    }

    public void setFamilyTree(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public void displayFamilyTreeInfo() {
        String info = familyTree.getInfo();
        view.displayFamilyTreeInfo(info);
    }

    public void addPerson(String name, Sex sex, LocalDate birthDate) {
        Human person = new Human(name, sex, birthDate);
        familyTree.add(person);
        view.displayMessage("Person added successfully.");
    }


    public void searchPerson(String name) {
        Human person = familyTree.getByName(name);
        if (person != null) {
            view.displayPersonInfo(person);
        } else {
            view.displayErrorMessage("Person not found.");
        }
    }

    public void sortByName() {
        familyTree.sortByName();
        view.displayMessage("Family tree sorted by name.");
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
        view.displayMessage("Family tree sorted by birth date.");
    }

    public void saveFamilyTree(String filePath) {
        boolean success = fileHandler.save(familyTree, filePath);
        if (success) {
            view.displayMessage("Family tree saved successfully.");
        } else {
            view.displayErrorMessage("Failed to save family tree.");
        }
    }

    public void loadFamilyTree(String filePath) {
        Object obj = fileHandler.read(filePath);
        if (obj instanceof FamilyTree) {
            FamilyTree<Human> loadedFamilyTree = (FamilyTree<Human>) obj;
            familyTree = loadedFamilyTree;
            view.displayMessage("Family tree loaded successfully.");
        } else {
            view.displayErrorMessage("Failed to load family tree.");
        }
    }

    public void clearFamilyTree() {
        familyTree.clear();
        view.displayMessage("Family tree cleared.");
    }
}
