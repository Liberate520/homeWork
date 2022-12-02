package service.analizator;

import java.util.Comparator;

public class FamiliesDescendantsComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.getDescendants(), o2.getDescendants());
    }
}
