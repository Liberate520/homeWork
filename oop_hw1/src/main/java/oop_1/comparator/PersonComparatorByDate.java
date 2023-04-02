package oop_1.comparator;

import oop_1.Person;

import java.util.Comparator;
// класс реализующий сравнение объектов Person по дате рождения
public class PersonComparatorByDate implements Comparator<Person> {
    // переопределенный метод для сортировки дерева по дате рождения
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getDateBirth(), o2.getDateBirth());
    }
}

