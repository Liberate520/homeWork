package ru.gb.family_tree.family_tree.model;


import ru.gb.family_tree.family_tree.model.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator<A extends TreeNode<A>> implements Iterator<Human> {
    private int index;
    private List<Human> humanList;

    public FamilyIterator(List<Human> humanList) {
        this.humanList= humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}