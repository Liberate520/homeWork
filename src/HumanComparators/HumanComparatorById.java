package HumanComparators;
import java.util.Comparator;

import human.Human;

public class HumanComparatorById implements Comparator<Human> {

        @Override
        public int compare(Human human1, Human human2) {
            return Integer.compare(human1.getId(), human2.getId());
        }

}
