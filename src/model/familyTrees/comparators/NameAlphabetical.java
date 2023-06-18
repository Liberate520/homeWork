package model.familyTrees.comparators;

import model.members.Member;

import java.util.Comparator;

/**
 * Компаратор NameAlphabetical предоставляет сравнение двух объектов, реализующих интерфейс Member, по алфавитному порядку имён.
 *
 * @param <T> Тип объекта, реализующего интерфейс Member.
 */
public class NameAlphabetical<T extends Member> implements Comparator<T> {
    /**
     * Сравнивает два объекта по алфавитному порядку имён.
     *
     * @param human1 Первый объект для сравнения.
     * @param human2 Второй объект для сравнения.
     * @return Значение 0, если имена объектов равны;
     */
    public int compare(T human1, T human2) {
        return human1.getName().compareTo(human2.getName());
    }
}
