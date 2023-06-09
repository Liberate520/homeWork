package family_tree;

import human.Human;
import human.comparators.HumanComparatorByChildrenCount;
import human.comparators.HumanComparatorByFirstName;
import human.comparators.HumanComparatorByLastName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem> implements Serializable, Iterable<T> {
    private List<T> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void addHuman(T human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getMother() != null) {
                human.getMother().addChild((Human) human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild((Human) human);
            }
        }
    }

    public String getHumanByName(String name) {
        for (T human : humanList) {
            if (human.getFirstName().equals(name)) {
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
