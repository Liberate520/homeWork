package org.genealogy.model.tree;

import org.genealogy.model.person.comparators.AnimalComparatorByAge;
import org.genealogy.model.person.comparators.AnimalComparatorByName;
import org.genealogy.model.tree.iterators.TreeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenealogyTree<E extends TreeItem> implements Iterable<E>{
    private List<E> animals;
    public GenealogyTree()
    {
        this.animals = new ArrayList<>();
    }

    public void addPerson(E animal)
    {
        animals.add(animal);
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(animals);
    }

    public void sortByName(){
        animals.sort(new AnimalComparatorByName<>());
    }

    public void sortByAge(){
        animals.sort(new AnimalComparatorByAge<>());
    }
}
