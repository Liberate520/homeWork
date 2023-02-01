package Homework_006.model;

import java.util.Comparator;

public class ComparatorByDate <T extends BaseType> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        String[] o1List = o1.getDate().split("\\.");
        String[] o2List = o2.getDate().split("\\.");

        for (int i = 2; i > 0; i--) {
            int rez = (o1List[i].compareTo(o2List[i]));
            if (rez < 0) {
                return -1;
            } else if (rez > 0) {
                return 1;
            }
        }
        return 0;
    }
}
