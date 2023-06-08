package HW.tree;

import HW.human.Human;
import HW.member.Member;
import HW.tree.comparators.SortByDateOfBirth;
import HW.tree.comparators.SortByName;
import HW.tree.comparators.SortByNameLength;
import HW.service.UpDownLoader;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree <T extends Member> implements Serializable, Iterable<T> {

    private List<T> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public void addPerson(T human) {
        humanList.add(human);
    }

    public void addAsChild(T human) {
        this.addPerson(human);
        if (human.getFather() != null) {
            human.getFather().setChildren(human);
        }
        if (human.getMother() != null) {
            human.getMother().setChildren(human);
        }

    }

    public T findPerson(String name, String surname) {
        for (T human : humanList) {
            if (human.getName().equals(name) && human.getSurname().equals(surname)) {
                return human;
            }
        }
        return null;
    }

    public void saver(UpDownLoader save) throws IOException {
        save.saver(this);
    }

    public static FamilyTree recovery(UpDownLoader load) throws IOException, ClassNotFoundException {
        return load.recovery();
    }

    @Override
    public Iterator iterator() {
        return humanList.listIterator();
    }

    public void sortByName() {
        humanList.sort(new SortByName());
    }

    public void sortByDateOfBirth() {
        humanList.sort(new SortByDateOfBirth());
    }

    public void printHList() {
        for (T human : humanList) {
            System.out.println(human);
        }
    }
    public void sortByNameLength() {
        humanList.sort(new SortByNameLength());
    }
}
