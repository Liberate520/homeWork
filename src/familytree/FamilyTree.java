package familytree;

import human.*;
import human.comparators.HumanComparatorByDateOfBirth;
import human.comparators.HumanComparatorByLastName;
import human.comparators.HumanComparatorByName;
import human.comparators.HumanComparatorByNumberOfChildren;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends Human > implements Serializable {
    private List<T> humans;

    public FamilyTree() {
        this.humans = new ArrayList<T>();
    }

    public void addHuman(T t) {
        if (!this.humans.contains(t)) {
            this.humans.add(t);
        }
    }

    public List<T> getHumans() {
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
