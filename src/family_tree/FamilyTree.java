package family_tree;

import human.Human;
import human.comparators.HumanComparatorByChildrenCount;
import human.comparators.HumanComparatorByFirstName;
import human.comparators.HumanComparatorByLastName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human) {
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

    public String getHumanByName(String name) {
        for (Human human : humanList) {
            if (human.getFirstName().equals(name)) {
                return human.getInfo();
            }
        }
        return null;
    }

    public String getHumanByBirthDate(String birthDate) {
        for (Human human : humanList) {
            if (human.getBirthDate().getYear() == Integer.parseInt(birthDate)) {
                return human.getInfo();
            }
        }
        return null;
    }

    public void sortByFirstName() {
        humanList.sort(new HumanComparatorByFirstName());
    }

    public void sortByLastName() {
        humanList.sort(new HumanComparatorByLastName());
    }

    public void sortByChildrenCount() {
        humanList.sort(new HumanComparatorByChildrenCount());
        Collections.reverse(humanList);
    }

    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }
}
