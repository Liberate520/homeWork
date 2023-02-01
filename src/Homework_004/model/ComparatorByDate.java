package Homework_004.model;

import java.util.Comparator;

public class ComparatorByDate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
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
