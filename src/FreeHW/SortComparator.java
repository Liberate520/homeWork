package FreeHW;


import java.util.Comparator;

public class SortComparator implements Comparator<Num> {

    /**
     * сортирует по последней цифре
     */
    public int compare(Num o1, Num o2) {
        int n1 = o1.selenium()%10;
        int n2 = o2.selenium()%10;
        return Integer.compare(n1, n2);
    }

}



