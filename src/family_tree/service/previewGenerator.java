package family_tree.service;

import family_tree.ftree.FamilyTree;
import family_tree.person.Gender;
import family_tree.person.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class previewGenerator {

    public static FamilyTree<Person> previewTree() {
        FamilyTree<Person> familyTree = new FamilyTree<>();

        Person rec1 = new Person("John", "Smith", Gender.Male, LocalDate.of(1965, 7, 14));
        Person rec2 = new Person("Mill", "Perri", Gender.Male, LocalDate.of(1940, 1, 19), LocalDate.of(1985, 4, 29), null, null, null);
        Person rec3 = new Person("Linda", "Wayne", Gender.Female, LocalDate.of(1943, 6, 29), LocalDate.of(2007, 7, 21), null, null, null);
        Person rec4 = new Person("Katty", "Perri", Gender.Female, LocalDate.of(1980, 8, 10), rec3, rec2);
        Person rec5 = new Person("Chris", "Nail", Gender.Male, LocalDate.of(1941, 10, 10), LocalDate.of(2003, 7, 21), null, null, null);
        Person rec6 = new Person("Serge", "Druon", Gender.Female, LocalDate.of(1970, 6, 1));
        Person rec7 = new Person("Ann", "Druon", Gender.Female, LocalDate.of(2004, 12, 7), rec4, rec6);
        Person rec8 = new Person("Moriss", "Druon", Gender.Male, LocalDate.of(2007, 3, 16), rec4, rec6);
        Person rec9 = new Person("Elly", "Nail", Gender.Female, LocalDate.of(1988, 3, 12), rec3, rec5);

        List<Person> marriage1 = new ArrayList<>();
        List<Person> marriage2 = new ArrayList<>();
        List<Person> marriage3 = new ArrayList<>();
        List<Person> marriage4 = new ArrayList<>();
        List<Person> marriage5 = new ArrayList<>();
        List<Person> marriage6 = new ArrayList<>();

        marriage1.add(rec2);
        marriage2.add(rec3);
        marriage3.add(rec3);
        marriage4.add(rec5);
        marriage5.add(rec6);
        marriage6.add(rec4);

        rec3.setMarriage(marriage1, "Perri", LocalDate.of(1966, 4, 17));
        rec3.setMarriage(marriage4, "Nail", LocalDate.of(1987, 2, 6));
        rec2.setMarriage(marriage2, null, LocalDate.of(1966, 4, 17));
        rec5.setMarriage(marriage3, null, LocalDate.of(1987, 2, 6));
        rec4.setMarriage(marriage5, "Druon-Perri", LocalDate.of(2002, 9, 11));
        rec6.setMarriage(marriage6, null, LocalDate.of(2002, 9, 11));


        familyTree.addPerson(rec1);
        familyTree.addPerson(rec2);
        familyTree.addPerson(rec3);
        familyTree.addPerson(rec4);
        familyTree.addPerson(rec5);
        familyTree.addPerson(rec6);
        familyTree.addPerson(rec7);
        familyTree.addPerson(rec8);
        familyTree.addPerson(rec9);

        return familyTree;

    }

}
