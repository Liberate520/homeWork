package treeAPI.familyTree.comparators;

import treeAPI.sample.Sample;

import java.util.Comparator;

public class SampleComparatorByBirthDay<E extends Sample> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        int result = o1.getBirthDay().compareTo(o2.getBirthDay());
        if (result == 0) result = o1.getFio().get(0).compareTo(o2.getFio().get(0));//продолжаем проверку,
        // так как даты могут совпадать, но имена нет - это разные люди?
        if (result == 0) result = o1.getFio().get(1).compareTo(o2.getFio().get(1));
        return result;
    }
}
