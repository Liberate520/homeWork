package model.service;

import model.family.Family;
import model.family.FamilyTree;
import model.people.Gender;
import model.people.Human;
import model.people.People;
import model.writer.FileHandler;
import java.time.LocalDate;

public class Service  {
    private People people;

    private final FileHandler fileHandler;

    public Service() {
        people = new People();
        fileHandler = new FileHandler();
    }

    public boolean addHuman(String name, String familyName, Gender gender, LocalDate birthData, int indexMother, int indexFather) {
        return people.addHuman(name, familyName, gender, birthData, indexMother, indexFather);
    }
    public boolean indexHumanTrue(int indexHuman) {
        return indexHuman < people.getHumanListSize();
    }
    public boolean humanDeath(int humanIndex, LocalDate deathDate) {
        return people.humanDeath(humanIndex, deathDate);
    }
    private Human getHuman(int index) {
        return people.getHuman(index);
    }

    public String getHumanFullInfo(int humanIndex) {
        return getHuman(humanIndex).fullInfo();
    }
    public String getFamilyTree(int humanIndex) {
        return new FamilyTree<>(getHuman(humanIndex)) + "\n";
    }
    public String getFamily(int humanIndex) {
        Family<Human> family = new Family<>();
        family.createFamily(getHuman(humanIndex));
        return family + "\n";
    }

    public String getAllHumans() {
        return people.getAllHumans();
    }
    public String getMan() {
        return people.getMan();
    }
    public String getWoman() {
        return people.getWoman();
    }

    public boolean saveHumanList() {
        return fileHandler.save(people);
    }
    public void loadHumanList() {
        people = (People) fileHandler.load();
    }

    public void sortByAge() {
        people.sortByAge();
    }
    public void sortByName() {
        people.sortByName();
    }
    public void sortByFamilyName() {
        people.sortByFamilyName();
    }
}
