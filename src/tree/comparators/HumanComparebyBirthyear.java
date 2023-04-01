package tree.comparators;
import java.util.Comparator;

import human.Human;

public class HumanComparebyBirthyear implements Comparator<Human> {

    @Override
    public int compare(Human h0, Human h1) {
        return Integer.compare(h0.getBirthyear(), h1.getBirthyear());
    }
}
