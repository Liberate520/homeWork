package homeWork.tree2.backend.familyTree.services;

import homeWork.tree2.backend.familyTree.FamilyTree;
import homeWork.tree2.backend.human.Human;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestGenerationFamilyTree {
    public FamilyTree<Human> testFamilyTree() {
        ArrayList<Human> people = new ArrayList<>();

        people.add(new Human("John", LocalDate.of(1950, 5, 15)));
        people.add(new Human("Elise", LocalDate.of(1951, 2, 11)));
        people.add(new Human("Mark", LocalDate.of(1974, 1, 11)));
        people.add(new Human("Iren", LocalDate.of(1976, 11, 7)));
        people.add(new Human("Nina", LocalDate.of(1998, 9, 9)));
        people.add(new Human("Artem", LocalDate.of(1999, 5, 5)));
        people.add(new Human("Jack", LocalDate.of(2010, 5, 12)));
        people.add(new Human("Jane", LocalDate.of(2012, 7, 12)));
        people.add(new Human("Alex", LocalDate.of(2014, 5, 15)));
        people.add(new Human("Soo", LocalDate.of(2017, 5, 30)));
        people.add(new Human("Six", LocalDate.of(2013, 1, 20)));
        people.add(new Human("Rafael", LocalDate.of(2009, 5, 30)));
        people.add(new Human("Leo", LocalDate.of(2001, 12, 10)));

        people.get(3).setFather(people.get(1));
        people.get(6).setMother(people.get(3));
        people.get(7).getChildren().add(people.get(3));
        people.get(8).getChildren().add(people.get(2));

        people.get(6).setFather(people.get(3));
        people.get(7).setMother(people.get(3));
        people.get(8).getChildren().add(people.get(5));

        FamilyTree<Human> familyTree = new FamilyTree<>();

        for (int i = 0; i < people.size(); i++) {
            familyTree.addPeople(people.get(i));
        }

        return familyTree;
    }

}
