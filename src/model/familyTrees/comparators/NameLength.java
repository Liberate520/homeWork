package model.familyTrees.comparators;

import model.members.Member;

import java.util.Comparator;

/**
 * Компаратор NameLength предоставляет сравнение двух объектов, реализующих интерфейс Member, по длине их имён.
 *
 * @param <T> Тип объекта, реализующего интерфейс Member.
 */
public class NameLength<T extends Member> implements Comparator<T> {
    /**
     * Сравнивает два объекта по длине их имён.
     *
     * @param human1 Первый объект для сравнения.
     * @param human2 Второй объект для сравнения.
     * @return Значение меньше 0, если длина имени первого объекта меньше длины имени второго объекта;
     */
    public int compare(T human1, T human2) {
        return human1.getName().length() - human2.getName().length();
    }
}
