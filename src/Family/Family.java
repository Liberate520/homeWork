package Family;

import Comparators.ComparatorByAge;
import Comparators.ComparatorByFamilyName;
import Comparators.ComparatorByName;
import Human.Human;

import java.util.*;

public class Family<E extends FamilyMember> implements Iterable<E>{
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

    public StringBuilder fullInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E e: family) stringBuilder.append(e.fullInfo()).append("\n");
        return stringBuilder;
    }

    public void sortByAge() {
        family.sort(new ComparatorByAge<>());
    }

    public void sortByName() {
        family.sort(new ComparatorByName<>());
    }

    public void sortByFamilyName() {
        family.sort(new ComparatorByFamilyName<>());
    }

    @Override
    public Iterator<E> iterator() {
        return family.iterator();
    }
}
