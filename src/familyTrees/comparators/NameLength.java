package familyTrees.comparators;

import members.Member;

import java.util.Comparator;

public class NameLength<T extends Member> implements Comparator<T> {
    public int compare(T human1, T human2) {
        return human1.getName().length() - human2.getName().length();
    }
}
