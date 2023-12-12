package model.family;

import model.comparators.ComparatorByAge;
import model.comparators.ComparatorByFamilyName;
import model.comparators.ComparatorByName;

import java.io.Serializable;
import java.util.*;

public class Family<E extends FamilyMember<E>> implements Serializable, Iterable<E>{
    private List<E> family;

    public Family() {
        family = new ArrayList<>();
    }

    public void createFamily(E e) {
        family = (List<E>) e.getChildrens();
        family.add(e);
        if (e.getFather() != null) family.add((E) e.getFather());
        if (e.getMother() != null) family.add((E) e.getMother());
    }

    @Override
    public String toString() {
        return "Члены семьи:" + family;
    }

    @Override
    public Iterator<E> iterator() {
        return family.iterator();
    }
}
