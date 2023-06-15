package model.familyTrees.iterators;

import model.members.Member;

import java.util.Iterator;
import java.util.List;

/**
 * Итератор PersonIterator предоставляет возможность итерации по списку объектов, реализующих интерфейс Member.
 *
 * @param <T> Тип объекта, реализующего интерфейс Member.
 */
public class FamilyTreeIterator<T extends Member> implements Iterator<T> {

    private int index;
    private List<T> personList;

    /**
     * Конструктор итератора PersonIterator.
     *
     * @param personList Список объектов, реализующих интерфейс Member.
     */
    public FamilyTreeIterator(List<T> personList) {
        this.personList = personList;
    }

    /**
     * Проверяет наличие следующего элемента в списке.
     *
     * @return true, если следующий элемент существует, иначе false.
     */
    @Override

    public boolean hasNext() {
        return index < personList.size();
    }

    /**
     * Возвращает следующий элемент из списка.
     *
     * @return Следующий элемент из списка.
     */
    @Override
    public T next() {
        return personList.get(index++);
    }
}
