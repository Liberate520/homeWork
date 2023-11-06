package ru.gb.f_tree.f_tree;

import ru.gb.f_tree.f_mem.FamilyMember;
import ru.gb.f_tree.human.Ageble;
import ru.gb.f_tree.human.Human;
import ru.gb.f_tree.human.Idable;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private int index;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
        this.index = 0;
    }

    public <T extends FamilyMember & Idable & Ageble> HumanIterator() {
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        if (hasNext()) {
            return humanList.get(index++);
        } else {
            throw new IndexOutOfBoundsException("Элементы списка закончились.");
        }
    }
}