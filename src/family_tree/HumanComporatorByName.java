package family_tree;

import java.util.Comparator;

public class HumanComporatorByName implements Comparator<Humans> {

    @Override
    public int compare(Humans o1, Humans o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
