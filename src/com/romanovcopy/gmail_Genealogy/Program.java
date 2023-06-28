package com.romanovcopy.gmail_Genealogy;

import java.time.LocalDate;

public class Program {

    public static void main(String[] args) {

        //создаем семейную пару
        LocalDate johnDOB = LocalDate.of(1950, 1, 1);
        LocalDate maryDOB = LocalDate.of(1952, 6, 15);
        Person john = new Person("John", "Doe", johnDOB, Person.Gender.MALE);
        john.setMaritalStatus(Person.MaritalStatus.MARRIED);
        Person mary = new Person("Mary", "Smith", maryDOB, Person.Gender.FEMALE);


        //создаем детей
        LocalDate peterDOB = LocalDate.of(1980, 3, 10);
        LocalDate annaDOB = LocalDate.of(1982, 8, 25);
        Person peter = new Person("Peter", "Doe", peterDOB, Person.Gender.MALE);
        peter.setMaritalStatus(Person.MaritalStatus.DIVORCED);
        Person anna = new Person("Anna", "Doe", annaDOB, Person.Gender.FEMALE);

        //добавляем детей
        john.addChild("Peter Jr.", "Doe", peterDOB, Person.Gender.MALE);
        john.addChild("Anna Jr.", "Doe", annaDOB, Person.Gender.FEMALE);

        //вывод семьи
        System.out.println(john);
        System.out.println(mary);
        System.out.println(peter);
        System.out.println(anna);
    }

}
