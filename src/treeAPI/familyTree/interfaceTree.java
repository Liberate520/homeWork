package treeAPI.familyTree;

import treeAPI.sample.Sample;

import java.util.List;

public interface interfaceTree<E extends Sample> extends Iterable{
    List<E> getSamples();
    //<E extends Sample> boolean addSample(E sample);
}
