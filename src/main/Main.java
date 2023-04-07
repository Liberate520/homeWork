package main;
import java.io.Serializable;
import java.io.*;
import java.time.LocalDate;

import person.Person;
import tree.FamilyTree;
import tree.Gender;
public class Main implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTolstoy = new FamilyTree();
        Service service = new Service(familyTolstoy);
        service.addPerson(1, "Куницин", "Алексей", LocalDate.of(1912, 11, 12), Gender.Male);

        service.addPerson(2, "Евгапова", "Надежда", LocalDate.of(1962, 1, 15), Gender.Female);

        service.addPerson(3, "Евгапова", "Нина", LocalDate.of(1947, 5, 01), Gender.Male);

        service.addPerson(4, "Евгапова", "Олеся", LocalDate.of(1974, 1, 25), Gender.Female);

        service.addPerson(5, "Евгапова", "Анастасия", LocalDate.of(1980, 05, 02), Gender.Female);

        service.addPerson(6, "Куликов", "Константин", LocalDate.of(2007, 8, 10), Gender.Male);

        service.addPerson(7, "Куликов", "Иван", LocalDate.of(2011, 4, 20), Gender.Male);
        
        service.sortByBirthDate();
        System.out.println("Отсортированный список по фамилии: ");
        for (Person item : familyTolstoy) {
            System.out.println(item);
        }
        System.out.println();
        service.sortByID();
        System.out.println("Отсортированный список по ID: ");
        for (Person item : familyTolstoy) {
            System.out.println(item);
        }
    }

}