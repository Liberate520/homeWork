package familyTrees.comparators;

import members.Member;

import java.util.Comparator;


public class NameAlphabetical<T extends Member> implements Comparator<T> {
    public int compare(T human1, T human2) {
        return human1.getName().compareTo(human2.getName());
    }
}
