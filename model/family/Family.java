package model.family;
import model.family.iterators.HumanIterator;
import model.human.comparators.HumanComparatorByAge;
import model.human.comparators.HumanComparatorByName;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Family<E extends Subject> implements Iterable<E> {
    private List<E> humanList;

    public Family() {
        humanList = new ArrayList<>();
    }

    public void addHuman(E human){

        humanList.add(human);
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge<>());
    }
}
