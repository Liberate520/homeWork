package model.family_tree;

import model.human.comparators.HumanComparatorByChildrenCount;
import model.human.comparators.HumanComparatorByFirstName;
import model.human.comparators.HumanComparatorByLastName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable, Iterable<T> {
    private List<T> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addHuman(T human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
        }
    }

    public String getHumanByName(String firstName, String lastName) {
        for (T human : humanList) {
            if (human.getFirstName().equals(firstName) && human.getLastName().equals(lastName)) {
                return human.getInfo();
            }
        }
        return null;
    }

    public String getHumanByBirthDate(String birthDate) {
        for (T human : humanList) {
            if (human.getBirthDate().getYear() == Integer.parseInt(birthDate)) {
                return human.getInfo();
            }
        }
        return null;
    }

    public void sortByFirstName() {
        humanList.sort(new HumanComparatorByFirstName<>());
    }

    public void sortByLastName() {
        humanList.sort(new HumanComparatorByLastName<>());
    }

    public void sortByChildrenCount() {
        humanList.sort(new HumanComparatorByChildrenCount<>());
    }

    @Override
    public Iterator<T> iterator() {
        return humanList.iterator();
    }
}
