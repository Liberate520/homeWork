package model.Service;

import java.util.Comparator;

import model.Animal;

public class IndividualComporatorByAge<T extends Animal> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getBirthYear(), o2.getBirthYear());
    }
}
