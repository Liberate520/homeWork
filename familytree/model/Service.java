package familytree.model;
import java.io.Serializable;
import java.time.LocalDate;

import familytree.model.family_tree.FamilyTree;
import familytree.model.human.Gender;
import familytree.model.human.Human;


public class Service implements Serializable {
    private FamilyTree<Human> familyTree;
    public Service() {
        familyTree = new FamilyTree<>();
    }
    public void addHuman(String name, String surname, LocalDate dateOfBirth, Human mother, Human father,
            Gender gender) {
        Human human = new Human(name, surname,gender, dateOfBirth ,father, mother);
        familyTree.add(human);
    }

    public void addHumanConsole(String name, String surname, Gender gender,LocalDate dateOfBirth) {
        Human human = new Human(name, surname,gender, dateOfBirth, null, null);
        familyTree.add(human);
    }

    // public void addHumanConsole(String name, String surname, Gender gender, LocalDate dateOfBirth) {
    //     Human human = new Human(name, surname, gender, dateOfBirth, null, null);
    //     familyTree.add(human);
    // }

    public String getInform() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Human human : familyTree) {
            str.append(human);
        }
        return str.toString();
    }
    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }


    public void sortBySurname() {
        familyTree.sortBySurname();
    }
}