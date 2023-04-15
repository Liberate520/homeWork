package treeUnits.comparators;

import treeUnits.Human;
import treeUnits.TreeUnit;

import java.util.Comparator;

public class CompHumanBySurname  implements Comparator<TreeUnit> {

    @Override
    public int compare(TreeUnit o1, TreeUnit o2) {
        if(o1 instanceof Human && o2 instanceof Human){
            return ((Human) o1).getSurname().compareTo(((Human) o2).getSurname());
        }else{
            return 0;
        }
    }
}