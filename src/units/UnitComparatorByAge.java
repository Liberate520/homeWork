package units;

import units.Unit;

import java.util.Comparator;

public class UnitComparatorByAge implements Comparator<Unit> {
    @Override
    public int compare(Unit o1, Unit o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
