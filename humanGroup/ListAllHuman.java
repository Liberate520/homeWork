package humanGroup;

import human.Human;
import human.comparators.HumanComparatorAge;
import human.comparators.HumanComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListAllHuman<E extends HumanGroupItem> implements Iterable<E> {
    private List<E> listAllHuman;

    public ListAllHuman() {
        this.listAllHuman = new ArrayList<>();
    }


    public void addHumans(E human) {
        listAllHuman.add(human);
    }

    @Override
    public Iterator<E> iterator() {
        return new ListAllHumanIterator<>(listAllHuman);
    }

    public  void sortByName() {
        listAllHuman.sort(new HumanComparatorByName<>());
    }

    public  void sortByAge() {
        listAllHuman.sort(new HumanComparatorAge<>());
    }
}
