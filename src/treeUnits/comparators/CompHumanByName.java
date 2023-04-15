package treeUnits.comparators;

import treeUnits.Human;
import treeUnits.TreeUnit;

import java.util.Comparator;

public class CompHumanByName implements Comparator<TreeUnit> {

    @Override
    public int compare(TreeUnit o1, TreeUnit o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
