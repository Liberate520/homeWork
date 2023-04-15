package treeUnits.comparators;

import treeUnits.Human;
import treeUnits.TreeUnit;

import java.util.Comparator;

public class CompHumanByDBR implements Comparator<TreeUnit> {
    @Override
    public int compare(TreeUnit o1, TreeUnit o2) {
        return o2.getDateBirth().compareTo(o1.getDateBirth());
    }
}
