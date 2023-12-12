package model.service;

import model.comparators.ComparatorByAge;
import model.comparators.ComparatorByFamilyName;
import model.comparators.ComparatorByName;
import model.family.Family;
import model.family.FamilyTree;
import model.human.Gender;
import model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static model.human.Gender.female;
import static model.human.Gender.male;

public class Service implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public Service() {
        humanList = new ArrayList<>();
    }

    public List<Human> getHumanList() {
        return humanList;
    }
    public boolean addHuman(String name, String familyName, Gender gender, LocalDate birthData, int indexMother, int indexFather) {
        Human human;
        if (indexMother < humanList.size() && indexFather < humanList.size()) {
            human = new Human(name, familyName, gender, birthData, getHuman(indexMother), getHuman(indexFather));
        }
        else if (indexMother >= humanList.size() && indexFather < humanList.size()) {
            human = new Human(name, familyName, gender, birthData, null, getHuman(indexFather));
        }
        else if (indexMother < humanList.size() && indexFather >= humanList.size()) {
            human = new Human(name, familyName, gender, birthData, getHuman(indexMother), null);
        }
        else {
            human = new Human(name, familyName, gender, birthData, null, null);
        }
        if (humanList.contains(human)) return false;
        else {
            humanList.add(human);
            return true;
        }
    }
    public boolean humanDeath(int humanIndex, LocalDate deathDate) {
        if (humanIndex < humanList.size() && humanList.get(humanIndex).getBirthData().getYear() < deathDate.getYear()) {
            humanList.get(humanIndex).setDeathData(deathDate);
            return true;
        }
        else return false;
    }

    public Human getHuman(int index) { return humanList.get(index);}
    public String getFamilyTree(int humanIndex) {
        if (humanIndex < humanList.size()) {
            return new FamilyTree<>(humanList.get(humanIndex)).toString() + "\n";
        }
        return "Человека с таким индексом нет в списке.\n";
    }
    public String getFamily(int humanIndex) {
        if (humanIndex < humanList.size()) {
            return createFamily(humanIndex).toString() + "\n";
        }
        return "Человека с таким индексом нет в списке.\n";
    }
    private Family createFamily(int humanIndex) {
        Family family = new Family<>();
        family.createFamily(humanList.get(humanIndex));
        return family;
    }
    public String getAllHumans() {
        return "Список людей:\n" + getByGender(null);
    }
    public String getMan() {
        return "Список мужчин:\n" + getByGender(female);
    }
    public String getWoman() {
        return "Список женщин:\n" + getByGender(male);
    }
    private String getByGender(Gender gender) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humanList) {
            if (human.getGender() != gender) {
                stringBuilder.append(humanList.indexOf(human));
                stringBuilder.append(" ");
                stringBuilder.append(human);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void sortByAge() {
        humanList.sort(new ComparatorByAge<>());
    }
    public void sortByName() {
        humanList.sort(new ComparatorByName<>());
    }
    public void sortByFamilyName() {
        humanList.sort(new ComparatorByFamilyName<>());
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }
}
