package model.Service;

import model.FamilyTree.FamilyTree;
import model.creature.Creature;
import model.creature.Gender;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Creature> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public Service(FamilyTree<Creature> familyTree) {
        this.familyTree = familyTree;
    }

    public Creature addCreature(String name, Gender gender, LocalDate dataBirth) {
        Creature creature = familyTree.createCreature(name, gender, dataBirth);
        familyTree.add(creature);
        return creature;
    }

    public String getCreatureListInfo() {
        return familyTree.toString();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthData() {
        familyTree.sortByBirthDate();
    }
}
