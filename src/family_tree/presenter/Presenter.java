package family_tree.presenter;

import family_tree.model.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private FamilyTree familyTree;

    public Presenter(View view) {
        this.view = view;
        familyTree = new FamilyTree();
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        familyTree.addHuman(name, birthDate, deathDate, gender);
    }

    public void setMother(int parentID, int childID){
        familyTree.addMother(parentID, childID);
    }

    public void setFather(int parentID, int childID){
        familyTree.addFather(parentID, childID);
    }

    public void showFamilyTree() {
        view.printText(familyTree.printFamilyTree());
    }

    public void sortByAge() {
        familyTree.sortByAge();
        showFamilyTree();
    }

    public void sortByName() {
        familyTree.sortByName();
        showFamilyTree();
    }

    public void sortByGender() {
        familyTree.sortByGender();
        showFamilyTree();
    }

    public Human findByID(int requiredID) {
        return (Human) familyTree.findHumanByID(requiredID);
    }

    public Human findByName(String requiredHuman) {
        return (Human) familyTree.findHumanByName(requiredHuman);
    }

    public List<String> showParentName(int childID) {
        return familyTree.getParentName(childID);
    }

    public List<String> showChildName(int id) {
        return familyTree.getChildName(id);
    }

    public List<String> showSiblingName(int id) {
        return familyTree.getSiblingName(id);
    }
}
