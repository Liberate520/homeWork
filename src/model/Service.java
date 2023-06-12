package model;

import model.family_tree.FamilyTree;
import model.family_tree.FamilyTreeItem;
import model.human.Human;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
        this.addHuman("Галина", "Гусина", LocalDate.of(1961, 4, 17), null, "Неизвестно", "Неизвестно", "Неизвестно", "Неизвестно");
        this.addHuman("Вячеслав", "Гусин", LocalDate.of(1959, 6, 25), null, "Неизвестно", "Неизвестно", "Неизвестно", "Неизвестно");
        this.addHuman("Сергей", "Гусин", LocalDate.of(1982, 12, 15), null, "Галина", "Гусина", "Вячеслав", "Гусин");
        this.addHuman("Евгения", "Петрова", LocalDate.of(1985, 9, 20), null, "Галина", "Гусина", "Вячеслав", "Гусин");
        this.addHuman("Александр", "Петров", LocalDate.of(2010, 5, 7), null, "Евгения", "Петрова", "Неизвестно", "Неизвестно");
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
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

    public void getHumanByName(String firstName, String lastName) {
        familyTree.getHumanByName(firstName, lastName);
    }

    public void getHumanByBirthDate(String year) {
        familyTree.getHumanByBirthDate(year);
    }
}
