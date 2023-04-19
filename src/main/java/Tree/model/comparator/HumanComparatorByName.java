package Tree.model.comparator;

import Tree.model.components.Human;

import java.util.Comparator;

// класс содержит реализующий метод compare сравнения имен определенный интерфейсом Comparator<T>
public class HumanComparatorByName<T extends Human> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getFullName().toLowerCase().compareTo(o2.getFullName().toLowerCase());
    }
}

