package family_tree;

import java.util.Comparator;

public class HumanComporatorByAge implements Comparator<Humans> {

    @Override
    public int compare(Humans o1, Humans o2) {
        if (o2.getBirthDate().isAfter(o1.getBirthDate())) {
            return 1;
        } else if (o2.getBirthDate().isEqual(o2.getBirthDate())) {
            return 0;
        } else {
            return -1;
        }
    }

}

