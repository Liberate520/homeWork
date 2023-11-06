package ru.gb.f_tree.comparators;

        import java.util.Comparator;
        import ru.gb.f_tree.human.Nameble;

        import java.util.Comparator;

public class FullNameComparator<T extends Nameble> implements Comparator<T> {
    @Override
    public int compare(T obj1, T obj2) {
        return obj1.getName().compareTo(obj2.getName());
    }
}