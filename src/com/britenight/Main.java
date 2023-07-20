package com.britenight;

import com.britenight.FamilyTree.FamilyTree;
import com.britenight.FamilyTree.Relation;
import com.britenight.FamilyTree.RelationType;
import com.britenight.Person.Gender;
import com.britenight.Person.Person;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.addPerson(new Person(0, "Sergey", LocalDate.parse("1980-02-24"), Gender.Male));
        tree.addPerson(new Person(1, "Ekaterina", LocalDate.parse("1976-06-11"), Gender.Female));
        tree.addPerson(new Person(2, "Ivan", LocalDate.parse("2001-09-29"), Gender.Male));
        tree.addPerson(new Person(3, "Elena", LocalDate.parse("1999-01-15"), Gender.Female));
        tree.addPerson(new Person(4, "Egor", LocalDate.parse("2023-04-14"), Gender.Male));
        tree.addPerson(new Person(5, "Anastasiya", LocalDate.parse("2021-07-11"), Gender.Female));

        tree.addRelation(new Relation(tree.getPeople().get(0), tree.getPeople().get(1), RelationType.Spouse));
        tree.addRelation(new Relation(tree.getPeople().get(1), tree.getPeople().get(0), RelationType.Spouse));

        tree.addRelation(new Relation(tree.getPeople().get(2), tree.getPeople().get(0), RelationType.Parent));
        tree.addRelation(new Relation(tree.getPeople().get(2), tree.getPeople().get(1), RelationType.Parent));
        tree.addRelation(new Relation(tree.getPeople().get(2), tree.getPeople().get(3), RelationType.Spouse));
        tree.addRelation(new Relation(tree.getPeople().get(3), tree.getPeople().get(2), RelationType.Spouse));

        tree.addRelation(new Relation(tree.getPeople().get(4), tree.getPeople().get(2), RelationType.Parent));
        tree.addRelation(new Relation(tree.getPeople().get(4), tree.getPeople().get(3), RelationType.Parent));
        tree.addRelation(new Relation(tree.getPeople().get(4), tree.getPeople().get(5), RelationType.Sibling));

        tree.addRelation(new Relation(tree.getPeople().get(5), tree.getPeople().get(2), RelationType.Parent));
        tree.addRelation(new Relation(tree.getPeople().get(5), tree.getPeople().get(3), RelationType.Parent));
        tree.addRelation(new Relation(tree.getPeople().get(5), tree.getPeople().get(4), RelationType.Sibling));

//        for (Person i : tree.getRelativePeople(tree.getPeople().get(2), true, RelationType.Parent)) {
//            System.out.println(i);
//        }
//
//        for (Person i : tree.getRelativePeople(tree.getPeople().get(4), true, RelationType.Sibling)) {
//            System.out.println(i);
//        }
//
//        for (Person i : tree.getRelativePeople(tree.getPeople().get(5), true, RelationType.Parent)) {
//            System.out.println(i);
//        }
    }
}
