package family_tree;

import java.util.Comparator;

public class HumanComporatorByName implements Comparator<Creature> {

    @Override
    public int compare(Creature o1, Creature o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
