package Human.Comparators;

import java.util.Comparator;

import Human.Human;

public class HumanComporatorById implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return (int)(o1.getId() - o2.getId());
    }
}
