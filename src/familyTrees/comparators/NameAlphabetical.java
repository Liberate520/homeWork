package familyTrees.comparators;

import human.Human;

import java.util.Comparator;


public class NameAlphabetical implements Comparator<Human> {
    public int compare(Human human1, Human human2) {
        return human1.getNAME().compareTo(human2.getNAME());
    }
}
