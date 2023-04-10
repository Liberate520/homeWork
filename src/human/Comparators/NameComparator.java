package human.Comparators;

import java.util.Comparator;

import human.Human;
public class NameComparator<T extends Human> implements Comparator<T> {
        @Override
        public int compare(T member1, T member2) {
            return member1.getName().compareTo(member2.getName());
        }

    }

