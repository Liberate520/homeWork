package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class FamilyTree<T extends Human> implements Iterable<T>, Serializable {
    private List<T> famTree = new ArrayList<>();

    public void addHuman(T human) {
        if (!famTree.contains(human)) {
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            famTree.add(human);
        }
    }
    public T findHuman(String name) {
        for (T human : famTree)
            if (human.getName().equals(name)) {
                return human;
            }
        return null;
    }

    public void sortByName() {
        famTree.sort(Comparator.comparing(Human::getName));
    }

    public void sortByBirthDate() {
        famTree.sort(Comparator.comparing(Human::getBirthDate));
    }

//    public void famSort() {
//        Collections.sort(famTree);
//    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyIterator<T>(famTree);
    }

    @Override
    public String toString() {
        return famTree.toString();
    }
}