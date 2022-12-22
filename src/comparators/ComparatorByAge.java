package homeWork.src.comparators;

import homeWork.src.Human;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Human> {
    /**
     * сравнение двух Human
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return результат сравнения Integer
     */
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
