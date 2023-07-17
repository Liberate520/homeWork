package OopJava.Human.Comparators;

import OopJava.Human.Human;

import java.util.Comparator;
public class ComparatorByYear<E extends Human> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        // TODO Auto-generated method stub
        if (o1.getYear() == o2.getYear())
            return 0;
        if (o1.getYear() > o2.getYear())
            return 1;
        else
            return -1;
    }
}
