package ru.gb.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ru.gb.family_tree.comparators.HumanComparatorByBirthDate;
import ru.gb.family_tree.comparators.HumanComporatorBySurname;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int personId;
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }
    
    public void addHuman(Human human) {
        human.setId(personId++);
        humans.add(human);
    }

    public void removeHuman(int id) {
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).id() == id) {
                humans.remove(i);
            }
        }
    }

    public void getHumans() {
        for (Human human : humans) {
            System.out.println(human);
        }
    }

    public void clearTree() {
        humans.clear();
    }

    public void sortByBirthDate() {
        humans.sort(new HumanComparatorByBirthDate());
    }

    public void sortBySurname() {
        humans.sort(new HumanComporatorBySurname());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);
    }
}
