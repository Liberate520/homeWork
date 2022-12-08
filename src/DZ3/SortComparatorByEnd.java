package DZ.DZ3;

import java.util.Comparator;

public class SortComparatorByEnd implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1%10, o2%10);
    }    
}
