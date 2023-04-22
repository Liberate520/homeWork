package units;

import units.Unit;

import java.util.Comparator;

public class UnitComparatorByName implements Comparator<Unit> {
    @Override
    public int compare(Unit o1, Unit o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
