package OopJava.Human.Comparators;

import OopJava.Human.Human;

import java.util.Comparator;
public class ComparatorByAge<E extends Human> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        // TODO Auto-generated method stub
        return o1.getName().compareTo(o2.getName());
    }
}
