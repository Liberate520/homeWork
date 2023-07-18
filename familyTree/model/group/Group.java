package familyTree.model.group;

import familyTree.model.group.iterators.HumanIterator;
import familyTree.model.human.comparators.HumanComparatorByAge;
import familyTree.model.human.comparators.HumanComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group<E extends GroupItem> implements Iterable<E> {
    private List<E> humonList;

    public Group() {
        humonList = new ArrayList<>();
    }

    public void addHuman(E human){
        humonList.add(human);
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humonList);
    }

    public void sortByName(){
        humonList.sort(new HumanComparatorByName<>());
    }
    public void sortByAge(){
        humonList.sort(new HumanComparatorByAge<>());
    }
}
