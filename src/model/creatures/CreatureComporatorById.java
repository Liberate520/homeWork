package model.creatures;

import java.util.Comparator;

public class CreatureComporatorById implements Comparator<Creature> {

    @Override
    public int compare(Creature o1, Creature o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
