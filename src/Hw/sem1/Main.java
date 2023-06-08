package Hw.sem1;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты Person
        Person john = new Person("John", Gender.MALE, LocalDate.of(1980, 5, 15), null);
        Person jane = new Person("Jane", Gender.FEMALE, LocalDate.of(1982, 9, 22), null);
        Person tom = new Person("Tom", Gender.MALE, LocalDate.of(2005, 3, 10), null);


        FamilyTree familyTree = new FamilyTree(john);


        familyTree.addChild(john, tom);


        tom.setFather(john);
        tom.setMother(jane);
    }
}