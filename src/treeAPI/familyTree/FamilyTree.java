package treeAPI.familyTree;

import treeAPI.sample.Sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FamilyTree<E extends Sample> implements interfaceTree, Serializable {
    private String name;
    private List<E> samples;
    private List<E> sampleOut; //temporary List

    public FamilyTree(String name) {
        this.setName(name);
        this.samples = new ArrayList<>();

    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public List<E> getSamples() {
        return this.samples;
    }
    private <E extends Sample> boolean hasSample(E sample) {return this.getSamples().contains(sample);}

    public <E extends Sample> boolean addSample(E sample) {return addSample(sample, false);}

    public <E extends Sample> boolean addSample(E sample, boolean isAddAllChildren) {
        if (!this.hasSample(sample)) {
            if (isAddAllChildren) {
                this.addChildren(sample);
            }
            return ((List<E>) this.getSamples()).add(sample);
        }
        return false;
    }

    private <E extends Sample> void addChildren(E sample) {
        if (this.hasSample(sample)) {
            if (sample.countChildren() != 0) {
                for (E own : (List<E>) sample.getChildren()) {
                    this.addSample(own, true);
                }
            }
        } else {
            this.addSample(sample, true);
        }
    }

    public E findSample(String name) {
        for (E sample : this.getSamples()) {
            if (sample.getNameString().equals(name)) {
                return sample;
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new SampleIterator<>(samples);
    }

    public String printAllInfo() {
        StringBuilder result = new StringBuilder();
        for (E own : this.getSamples()) {
            result.append(own.print() + "\n");
        }
        return result.toString();

    }

    public String printTree() {
        StringBuilder result = new StringBuilder();
        sampleOut = new ArrayList<>();
        result.append(String.format("Фамильное дерево %s\n", this.getName()));
        for (E sample : this.getSamples()) {
            if (!sampleOut.contains(sample)) {
                result = printTree(result, sample);
            }
        }
        return result.toString();
    }

    public StringBuilder printTree(StringBuilder result, E sample) {
        while (((List<E>) sample.getParents()).size() > 0) {
            for (E m : (List<E>) sample.getParents()) {
                if (samples.contains(m)) {
                    sample = m;
                }
            }
        }
        result = printTree(result, sample, 1);
        return result;
    }

    private StringBuilder printTree(StringBuilder result, E sample, int iter) {
        String space = "  ";
        String marriedName = "";
        if (sample.getMarried() != null) {
            ((List<E>) sampleOut).add((E) sample.getMarried());
            marriedName = "+" + sample.getMarried().print();
        }
        result.append(String.format("%s%s%s|", sample.print(), marriedName, space));
        ((List<E>) sampleOut).add(sample);
        if (sample.countChildren() > 0) {
            ListIterator<E> children = ((List<E>) sample.getChildren()).listIterator();
            while (children.hasNext()) {
                if (children.nextIndex() > 0) result.append(space);
                result = printTree(result, children.next(), iter + 1);
            }
        } else {
            result.append("\n");
        }
        return result;
    }
}