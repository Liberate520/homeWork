package model.human.comparators;

import model.tree.FamilyTreeItem;

import java.util.Comparator;

public class ComparatorById <T extends FamilyTreeItem<T> > implements Comparator< T > {

        @Override
        public int compare(T o1, T o2) {

            return Integer.compare(Integer.parseInt(o1.getId().replace(". ", "")), Integer.parseInt(o2.getId().replace(". ", "")));
        }

}
