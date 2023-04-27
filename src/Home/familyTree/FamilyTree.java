package Home.familyTree;

import Home.*;
import Home.human.Human;
import Home.human.comparators.HumanComparatorByAge;
import Home.human.comparators.HumantComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E> implements Iterable<E> {
    private List<E> humanList;
    public FamilyTree(){
        humanList = new ArrayList<>();
    }
    public  void addToFamily(E e){
        humanList.add(e);
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumantComparatorByName());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }


}
