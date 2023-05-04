package model.humans.comporator;

import model.humans.FamilyTreeItem;

import java.util.Comparator;

public class HumanNameComporator<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E human1, E human2) {
        return human1.getFirstName().compareTo(human2.getFirstName());
    }
}
