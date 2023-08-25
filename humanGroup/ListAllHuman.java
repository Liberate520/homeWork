package humanGroup;

import human.Human;
import human.comparators.HumanComparatorAge;
import human.comparators.HumanComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;

public class ListAllHuman implements Iterable<Human> {
    private static ArrayList<Human> listAllHuman;

    public ListAllHuman() {
        this.listAllHuman = new ArrayList<>();
    }


    public void addHumans(Human human) {
        listAllHuman.add(human);
    }

    @Override
    public Iterator<Human> iterator() {
        return new ListAllHumanIterator(listAllHuman);
    }

    public static void sortByName() {
        listAllHuman.sort(new HumanComparatorByName());
    }

    public static void sortByAge() {
        listAllHuman.sort(new HumanComparatorAge());
    }
}
