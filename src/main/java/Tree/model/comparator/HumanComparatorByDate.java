package Tree.model.comparator;

import Tree.model.components.Human;

import java.util.Comparator;

// класс содержит реализующий метод compare сравнения дат рождения определенный интерфейсом Comparator<T>
public class HumanComparatorByDate<T extends Human> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getYearOfBirth(), o2.getYearOfBirth());
    }
}
