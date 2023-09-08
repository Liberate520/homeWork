package ru.gb.Tree.Model.Human.Comparators;

import ru.gb.Tree.Model.FamilyTree.TreeItem;
import java.util.Comparator;

public class HumanComparatorByName <T extends TreeItem> implements Comparator<T>{   // забыл спросить на семинаре
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
