package human.Comparators;

import human.Human;

import java.util.Comparator;

public class DateComparator implements Comparator<Human>{
        @Override
        public int compare(Human member1, Human member2) {
            return Integer.compare(member1.getDate(), member2.getDate());
        }

    }

