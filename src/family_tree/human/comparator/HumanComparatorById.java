package family_tree.human.comparator;

import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorById implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2){
        return Long.compare(o1.getId(), o2.getId());
    }
}
