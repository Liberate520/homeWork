package HW;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import HW.Iterator.FamilyComparatorAge;
import HW.Iterator.HumanComparaterDataBirth;
import HW.Iterator.HumanComparatorByName;

public class FamilyTree<T extends FamilyMember> implements Iterable<T> {
    private List<T> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;

    }


    public boolean add(T human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add((T) human);
            // if (human.getFather() != null) {
            //     human.getFather().addChild(human);
            // }
            // if (human.getMather() != null) {
            //     human.getMather().addChild(human);
            // }
            return true;
        }
        return false;
    }

    public T getByName(String name) {
        for (T human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {

        return humanList.toString();
    }

    public List<T> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<T> humanList) {
        this.humanList = humanList;
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<T>());;
    }

    public void sortByAge() {
        Collections.sort(humanList, new FamilyComparatorAge<T>());
    }
    public void sortByDataBirth() {
        humanList.sort(new HumanComparaterDataBirth<T>());
    }

    @Override
    public Iterator<T> iterator() {

        return humanList.iterator();
    }

}