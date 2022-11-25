package analizator;

import java.util.Comparator;

public class FamiliesDescendantsComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.getDescendants(), o2.getDescendants());
//        int number1 = o1.getDescendants();
//        int number2 = o2.getDescendants();
//        return number1 >= number2 ? (number1 == number2 ? 0 : 1) : -1;
    }
}
