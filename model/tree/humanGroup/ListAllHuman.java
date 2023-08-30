package model.tree.humanGroup;

import model.human.Human;
import model.human.comparators.HumanComparatorAge;
import model.human.comparators.HumanComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListAllHuman<E extends HumanGroupItem> implements Iterable<E> {
    private List<E> listAllHuman;
    private String name;


    public String getName() {
        return name;
    }

    public ListAllHuman() {
        this.listAllHuman = new ArrayList<>();
        this.name = name;

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
