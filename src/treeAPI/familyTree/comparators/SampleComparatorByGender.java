package treeAPI.familyTree.comparators;

import treeAPI.sample.Sample;

import java.util.Comparator;

public class SampleComparatorByGender<E extends Sample> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        int result = o1.getGender().compareTo(o2.getGender());
        if (result == 0) result = o1.getFio().get(0).compareTo(o2.getFio().get(0));
        if (result == 0) result = o1.getFio().get(1).compareTo(o2.getFio().get(1));
        if (result == 0) result = o1.getBirthDay().compareTo(o2.getBirthDay());
        return result;
    }
}
