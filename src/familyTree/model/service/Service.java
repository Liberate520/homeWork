package familyTree.model.service;

import familyTree.model.familyTree.FamilyTree;
import familyTree.model.human.Gender;
import familyTree.model.human.Human;

import java.time.LocalDate;

public class Service {
    private int idHuman;
    private FamilyTree<Human> family;

    public Service() {
        family = new FamilyTree<>();
    }

    public void addToFamily(String name, LocalDate dateBirth, Gender gender) {
        Human human = new Human(name, dateBirth, gender);
        idHuman++;
        family.addToFamily(human);
    }

    public void addToFamily(String name, LocalDate dateBirth, Gender gender, Human mother, Human father) {
        Human human = new Human(name, gender, dateBirth, mother, father);
        idHuman++;
        family.addToFamily(human);
    }

    public String getFamilyInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Full info of FamilyTree:\n");
        for (Human human : family) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        family.sortByName();
    }

    public void sortByAge() {
        family.sortByAge();
    }
}
