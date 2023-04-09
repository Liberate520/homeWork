package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class FamilyTree implements Iterable<Human> {
    private ArrayList<Human> famTree = new ArrayList<>();

    public void addHuman(Human human) {
        famTree.add(human);
        if (human.getMother() != null)
            human.getMother().addChild(human);

        if (human.getFather() != null)
            human.getFather().addChild(human);
    }

    public String findHuman(String name) {
        for (Human human : famTree)
            if (human.getName().contains(name)) {
                return human.toString();
            }
        return null;
    }
    public void sortByName() {
        famTree.sort(Comparator.comparing(Human::getName));
    }
    public void sortByBirthDate() {
        famTree.sort(Comparator.comparing(Human::getBirthDate));
    }

    public void famSort() {
        Collections.sort(famTree);
    }

    @Override
    public Iterator<Human> iterator() {
        return famTree.iterator();
    }

    @Override
    public String toString() {
        return famTree.toString();
    }


}