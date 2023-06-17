package model;

import model.family_tree.FamilyTree;
import model.family_tree.FamilyTreeItem;
import model.file_handler.FileHandler;
import model.human.Human;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public Service() {
        this.familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public void addHuman(String firstName, String lastName,
                         LocalDate birthDate, LocalDate deathDate,
                         String firstMomName, String lastMomName,
                         String firstDadName, String lastDadName) {
        familyTree.addHuman(new Human(firstName, lastName, birthDate, deathDate, firstMomName, lastMomName, firstDadName, lastDadName));
    }

    public String getHumanList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (FamilyTreeItem human : familyTree) {
            stringBuilder.append(human.getInfo());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByFirstName() {
        familyTree.sortByFirstName();
    }

    public void sortByLastName() {
        familyTree.sortByLastName();
    }

    public void sortByChildrenCount() {
        familyTree.sortByChildrenCount();
    }

    public String getHumanByName(String firstName, String lastName) {
        return familyTree.getHumanByName(firstName, lastName);
    }

    public String getHumanByBirthDate(String year) {
        return familyTree.getHumanByBirthDate(year);
    }
}
