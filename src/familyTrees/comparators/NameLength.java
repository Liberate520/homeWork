package familyTrees.comparators;

import human.Human;

import java.util.Comparator;

public class NameLength implements Comparator<Human> {
    public int compare(Human human1, Human human2) {
        return human1.getNAME().length() - human2.getNAME().length();
    }
}
