package homeWork.tree2.backend.familyTree.comparator;

import homeWork.tree2.backend.human.HumanObjectInterface;

import java.util.Comparator;

public class HumanObjectInterfaceComparatorbyName implements Comparator<HumanObjectInterface> {
    @Override
    public int compare(HumanObjectInterface o1, HumanObjectInterface o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public Comparator<HumanObjectInterface> reversed() {
        return Comparator.super.reversed();
    }
}

// Проблем не наблюдаю