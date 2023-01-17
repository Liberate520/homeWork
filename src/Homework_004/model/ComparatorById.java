package Homework_004.model;

import java.util.Comparator;

public class ComparatorById implements Comparator<BaseType>  {
    @Override
    public int compare(BaseType o1, BaseType o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
