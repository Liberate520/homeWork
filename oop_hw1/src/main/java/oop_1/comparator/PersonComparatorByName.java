package oop_1.comparator;

import oop_1.Person;

import java.util.Comparator;
// класс реализующий сравнение объектов Person по имени
public class PersonComparatorByName implements Comparator<Person>{
    // переопределенный метод для сортировки дерева по полному имени
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }

}

