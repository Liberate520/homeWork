package model;

import model.person.Gender;
import model.person.Person;
import model.tree.Tree;

import java.time.LocalDate;

public class Data {
    public static Tree dataEntry() {
        Tree<Person> tree = new Tree<>();
        tree.addPerson(new Person("Татьяна", LocalDate.of(1951, 1, 10), Gender.Female));
        tree.addPerson(new Person("Сергей", LocalDate.of(1951, 10, 23), Gender.Male));
        tree.addPerson(new Person("Алексей", LocalDate.of(1984, 7, 11), Gender.Male,
                tree.findPersonByName("Татьяна"), tree.findPersonByName("Сергей")));
        tree.addPerson(new Person("Ирина", LocalDate.of(1987, 7, 1), Gender.Female));
        tree.addPerson(new Person("Стёпа", LocalDate.of(2017, 4, 21), Gender.Male,
                tree.findPersonByName("Ирина"), tree.findPersonByName("Алексей")));
        tree.addPerson(new Person("Петя", LocalDate.of(2018, 9, 30), Gender.Male,
                tree.findPersonByName("Ирина"), tree.findPersonByName("Алексей")));
        tree.addPerson(new Person("Маша", LocalDate.of(2021, 6, 14), Gender.Female,
                tree.findPersonByName("Ирина"), tree.findPersonByName("Алексей")));
        tree.addPerson(new Person("Вика", LocalDate.of(2021, 6, 14), Gender.Female,
                tree.findPersonByName("Ирина"), tree.findPersonByName("Алексей")));
        return tree;
    }
}