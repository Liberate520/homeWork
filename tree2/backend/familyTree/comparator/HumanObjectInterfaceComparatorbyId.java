package homeWork.tree2.backend.familyTree.comparator;

import homeWork.tree2.backend.human.HumanObjectInterface;

import java.util.Comparator;

public class HumanObjectInterfaceComparatorbyId implements Comparator<HumanObjectInterface> {
    @Override
    public int compare(HumanObjectInterface o1, HumanObjectInterface o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }

    @Override
    public Comparator<HumanObjectInterface> reversed() {
        return Comparator.super.reversed();
    }
}

// Проблем не наблюдаю