package human.Comparators;

import java.util.Comparator;

import human.Human;
public class NameComparator implements Comparator<Human> {
        @Override
        public int compare(Human member1, Human member2) {
            return member1.getName().compareTo(member2.getName());
        }

    }

