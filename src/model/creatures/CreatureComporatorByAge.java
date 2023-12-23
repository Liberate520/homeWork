package model.creatures;

import java.util.Comparator;

public class CreatureComporatorByAge implements Comparator<Creature> {

    @Override
    public int compare(Creature o1, Creature o2) {
        if (o2.getBirthDate().isAfter(o1.getBirthDate())) {
            return 1;
        } else {
            return -1;
        }
    }

}

