package human.comparator;

import human.Human;

import java.util.Comparator;

public abstract class HumanComparator implements Comparator<Human> {
    @Override
    public abstract int compare(Human h1, Human h2);
}
