package treeAPI.familyTree;

import treeAPI.sample.Sample;

import java.util.Iterator;
import java.util.List;

public class SampleIterator<E extends Sample> implements Iterator<E> {

    private int index;
    private List<E> samples;

    public SampleIterator(List<E> members) {
        this.samples = members;
    }


    @Override
    public boolean hasNext() {
        return index < this.samples.size();
    }

    @Override
    public E next() {
        return this.samples.get(index++);
    }
}
