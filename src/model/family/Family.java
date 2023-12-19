package model.family;

import java.util.*;

public class Family<E extends FamilyMember<E>> implements Iterable<E>{
    private final List<E> family;

    public Family() {
        family = new ArrayList<>();
    }

    public void createFamily(E e) {
        family.addAll(e.getChildrens());
        family.add(e);
        if (e.getFather() != null) family.add(e.getFather());
        if (e.getMother() != null) family.add(e.getMother());
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
