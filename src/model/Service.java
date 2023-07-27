package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {

    private FamilyTree<Entities> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, String surname, LocalDate dateOfBirth, Human mother, Human father,
            Gender gender) {
        Human human = new Human(name, surname, dateOfBirth, mother, father, gender);
        familyTree.add(human);
    }

    public void addHuman(String name, String surname, Gender gender, LocalDate dateOfBirth) {
        addHuman(name, surname, dateOfBirth, null, null, gender);
    }

    public void addHuman(String name, String surname, LocalDate dateOfBirth) {
        addHuman(name, surname, null, dateOfBirth);
    }

    public void addHuman(String name, String surname, Gender gender) {
        addHuman(name, surname, gender, null);
    }

    public String getInformation() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Entities human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByBirthdate() {
        familyTree.sortByBirthdate();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public String toString() {
        StringBuilder strb = new StringBuilder();
        for (Entities human : familyTree) {
            strb.append(human);
        }
        return strb.toString();
    }

}
