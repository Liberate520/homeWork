package familytree;

import human.*;
import human.comparators.HumanComparatorByDateOfBirth;
import human.comparators.HumanComparatorByLastName;
import human.comparators.HumanComparatorByName;
import human.comparators.HumanComparatorByNumberOfChildren;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        if (!this.humans.contains(human)) {
            this.humans.add(human);
        }
    }

    public List<Human> getHumans() {
        return humans;
    }

    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Human human : humans) {
            stringBuilder.append(human.getGeneralInfo()).append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        humans.sort(new HumanComparatorByName());
    }

    public void sortByLastName() {
        humans.sort(new HumanComparatorByLastName());
    }

    public void sortByNumberOfChildren() {
        humans.sort(new HumanComparatorByNumberOfChildren());
    }

    public void sortByDateOfBirth() {
        humans.sort(new HumanComparatorByDateOfBirth());
    }
}
