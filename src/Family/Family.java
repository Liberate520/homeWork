package Family;

import Comparators.ComparatorByAge;
import Comparators.ComparatorByFamilyName;
import Comparators.ComparatorByName;
import Human.Human;

import java.util.*;

public class Family implements Iterable<Human>{
    private List<Human> family;

    public Family() {
        family = new ArrayList<>();
    }

    public void createFamily(Human human) {
        family = human.getChildrens();
        family.add(human);
        if (human.getFather() != null) family.add(human.getFather());
        if (human.getMother() != null) family.add(human.getMother());
    }

    @Override
    public String toString() {
        return "Члены семьи:" + family;
    }

    public StringBuilder fullInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: family) stringBuilder.append(human.fullInfo()).append("\n");
        return stringBuilder;
    }

    public void sortByAge() {
        family.sort(new ComparatorByAge());
    }

    public void sortByName() {
        family.sort(new ComparatorByName());
    }

    public void sortByFamilyName() {
        family.sort(new ComparatorByFamilyName());
    }

    @Override
    public Iterator<Human> iterator() {
        return family.iterator();
    }
}
