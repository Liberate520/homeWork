package human.Comparators;

import human.Human;

import java.util.Comparator;

public class DateComparator<T extends Human> implements Comparator<T>{
        @Override
        public int compare(T member1, T member2) {
            return Integer.compare(member1.getDate(), member2.getDate());
        }

    }

