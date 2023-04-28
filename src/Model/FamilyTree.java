package Model;

import Model.service.FileHandlers.Writable;
import Model.units.UnitComparatorByAge;
import Model.units.UnitComparatorByName;
import Model.units.Unit;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Unit> implements Serializable, Iterable<T> {
    private List<T> currentList;


    public FamilyTree() {
        this.currentList = new ArrayList<>();
    }

    public FamilyTree(List<T> currentList) {
        this.currentList = currentList;
    }

    public void add(T unit) {
        if (unit != null) {
            if (!currentList.contains(unit)) {
                currentList.add(unit);
                if (unit.getMother() != null) {
                    unit.getMother().addChild(unit);
                }
                if (unit.getFather() != null) {
                    unit.getFather().addChild(unit);
                }
            }
        }
    }

    public T getByName(String name) {
        for (T unit : currentList) {
            if (unit.getName().equals(name)) return unit;
        }
        return null;
    }

    public String getInfo() {
        StringBuilder str = new StringBuilder();
        str.append("В дереве: ");
        str.append(currentList.size());
        str.append(" объект(ов).\n");
        for (T unit : currentList) {
            str.append(unit.getRelatives());
            str.append("\n");
        }
        return str.toString();
    }

    public void save(Writable writable, String path) throws IOException {
        writable.save(this, path);
    }

    @Override
    public Iterator<T> iterator() {
        return currentList.iterator();
    }

    public void sortByName() {
        currentList.sort(new UnitComparatorByName());
    }

    public void sortByAge() {
        currentList.sort(new UnitComparatorByAge());
    }
}
