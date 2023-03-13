package Model.GenealogicalTree.Comporator;

import java.util.Comparator;

import Model.GenealogicalTree.Animal;

public class IndividualComporatorByAge<T extends Animal> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getBirthYear(), o2.getBirthYear());
    }
}
