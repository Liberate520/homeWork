package Tree;

import Human.Human;
import Tree.Comparators.humanComparatorByAge;
import Tree.Comparators.humanComparatorBySecondName;
import Tree.Comparators.humanComparatorBySex;

import java.io.Serializable;
import java.util.*;

public class Tree<E extends Human> implements Serializable, Iterable<E> {
    private List<E> relatives;

    public Tree() {
        this.relatives = new ArrayList<>();
    }

    public Tree(List<E> relatives) {

        this.relatives = relatives;
    }

    public List<E> getRelatives() {
        return relatives;
    }

    public void add(E human) {
        if (!relatives.contains(human)) {
            relatives.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getWifeOrHusband() != null) {
                human.getWifeOrHusband().setWifeOrHusband(human);
            }
        }
    }

    public void createFamily(E father, E mother, E child) {
        child.setFather(father);
        child.setMother(mother);
        mother.setWifeOrHusband(father);
        if (!relatives.contains(mother)) {
            relatives.add(mother);
        }
        if (!relatives.contains(father)) {
            relatives.add(father);
        }
        if (!relatives.contains(child)) {
            relatives.add(child);
        }
    }

    public Human getByName(String name) {
        String[] tempString = name.split(" ");
        for (E human : relatives) {
            if (human.getSecondName() == tempString[0]
                    && human.getFirstName() == tempString[1]
                    && human.getPatronymic() == tempString[2]) {
                return human;
            }
        }
        return null;
    }


    @Override
    public Iterator<E> iterator() {
        return new humanIterator(relatives);
    }


    public void sortBySecondName() {
        relatives.sort(new humanComparatorBySecondName());
    }

    public void sortBySex() {
        relatives.sort((Comparator<? super E>) new humanComparatorBySex());
    }

    public void sortByYear() {
        relatives.sort((Comparator<? super E>) new humanComparatorByAge());
    }
}
