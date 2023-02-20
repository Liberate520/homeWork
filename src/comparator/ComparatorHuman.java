package org.example.comparator;

import org.example.Human;
import java.util.Comparator;

public class ComparatorHuman implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return 0;                                        // перегрузка в дереве
    }
}

