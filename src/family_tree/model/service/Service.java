package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.E;
import family_tree.model.human.Gender;
import family_tree.model.writer.Writable;

import java.time.LocalDate;

public class Service {

    private FamilyTree tree;
    private Writable writable;


    public Service() {
        tree = new FamilyTree<>();
    }
    public void sortByName() {
        tree.sortByName();
    }
    public void sortByBirthDate() {
        tree.sortByBirthDate();
    }
    public String getInfo() {
        return tree.getInfo();
    }
    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        E human = new E(name, gender, birthDate);
        tree.add(human);
        getInfo();
    }


}
