package model.familyTrees.comparators;

import model.members.Member;

import java.util.Comparator;

/**
 * Компаратор ByDateBirth предоставляет сравнение двух объектов, реализующих интерфейс Member, по году рождения.
 *
 * @param <T> Тип объекта, реализующего интерфейс Member.
 */
public class ByDateBirth<T extends Member> implements Comparator<T> {
    /**
     * Сравнивает два объекта по году рождения.
     *
     * @param o1 Первый объект для сравнения.
     * @param o2 Второй объект для сравнения.
     * @return Значение 0, если годы рождения объектов равны;
     */
    @Override
    public int compare(T o1, T o2) {
        return o1.getYearOfBirth().compareTo(o2.getYearOfBirth());
    }
}
