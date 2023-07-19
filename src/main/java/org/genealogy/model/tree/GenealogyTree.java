package org.genealogy.model.tree;

import org.genealogy.model.person.comparators.HumanComparatorByAge;
import org.genealogy.model.person.comparators.HumanComparatorByName;
import org.genealogy.model.tree.iterators.TreeIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenealogyTree<E extends TreeItem> implements Iterable<E>{
    private List<E> people;
    public GenealogyTree()
    {
        this.people = new ArrayList<>();
    }

    public void addHuman(E person)
    {
        people.add(person);
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(people);
    }

    public void sortByName(){
        people.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        people.sort(new HumanComparatorByAge<>());
    }
}
