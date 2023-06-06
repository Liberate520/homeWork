package HW.Tree;

import HW.Human.Human;
import HW.Tree.Comparators.SortByDateOfBirth;
import HW.Tree.Comparators.SortByName;
import HW.Tree.Comparators.SortByNameLength;
import HW.Service.UpDownLoader;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public void addPerson(Human human) {
        humanList.add(human);
    }

    public void addAsChild(Human human) {
        this.addPerson(human);
        if (human.getFather() != null) {
            human.getFather().setChildren(human);
        }
        if (human.getMother() != null) {
            human.getMother().setChildren(human);
        }

    }

    public Human findPerson(String name, String surname) {
        for (Human human : humanList) {
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

    public void SortByName() {
        humanList.sort(new SortByName());
    }

    public void SortByDateOfBirth() {
        humanList.sort(new SortByDateOfBirth());
    }

    public void PrintHList() {
        for (Human human : humanList) {
            System.out.println(human);
        }
    }
    public void SortByNameLength() {
        humanList.sort(new SortByNameLength());
    }
}
