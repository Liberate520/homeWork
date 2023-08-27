package App;

import Fileworks.FamilyTreeFileManager;
import Model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GenealogyApp {
    public static void main(String[] args) {

        Person person1 = new Person(1,"John","Smith",Gender.MALE,LocalDate.of(1971,8,8),null);
        Person person2 = new Person(2,"Alise","Smith", Gender.FEMALE,LocalDate.of(1974,3,5),null);
        Person person3 = new Person(3,"Ann","Smith",Gender.FEMALE,LocalDate.of(1998,9,11),null);
        Person person4 = new Person(4,"Will","Smith",Gender.MALE,LocalDate.of(1901,1,2),LocalDate.of(1992,4,13));

        Relationship spouseRelationship = new Relationship(person1, person2, RelationshipType.SPOUSE);
        Relationship childRelationship1 = new Relationship(person1, person3, RelationshipType.CHILD);
        Relationship childRelationship2 = new Relationship(person2, person3, RelationshipType.CHILD);
        Relationship fatherRelationship = new Relationship(person3, person1, RelationshipType.FATHER);
        Relationship motherRelationship = new Relationship(person3, person2, RelationshipType.MOTHER);
        Relationship fatherRelationship2 = new Relationship(person4, person1, RelationshipType.FATHER);

        // Automate relationship adding
        person1.addRelationship(spouseRelationship);
        person2.addRelationship(spouseRelationship);
        person1.addRelationship(childRelationship1);
        person2.addRelationship(childRelationship2);
        person3.addRelationship(fatherRelationship);
        person3.addRelationship(motherRelationship);
        person1.addRelationship(fatherRelationship2);

        FamilyTree familyTree = new FamilyTree(List.of(person1, person2, person3, person4));

        List<Person> people = List.of(person1, person2, person3, person4);
        FamilyTreeFileManager fileManager = new FamilyTreeFileManager(people);
//        try {
//            /*Save and load family tree from file*/
//           fileManager.saveFamilyTree("family_tree.dat");
//           fileManager.loadFamilyTree("family_tree.dat");
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        try {
            fileManager.loadFamilyTree("family_tree.dat");

            List<Relationship> allRelationships = familyTree.getAllRelationships();
            List<Person> allPeople = familyTree.getAllPeople();

            // Вывод информации о загруженных отношениях и людях
            System.out.println("All Relationships:");
            for (Relationship relationship : allRelationships) {
                System.out.println(relationship);
            }

            System.out.println("All People:");
            for (Person person : allPeople) {
                System.out.println(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


//        List<Model.Relationship> allRelationships = familyTree.getAllRelationships();
//        System.out.println(allRelationships);
//        System.out.println(familyTree.getAllPeople());

        System.out.println("Age " + person4.getFullName() + ": " + person4.getAge() + " years");

        /*if (person4.isAlive()) {
            System.out.println(person4.getFullName() + " Alive.");
        } else {
            System.out.println("Died at " + person4.getDeathYear());
            System.out.println("Time since death " + person4.getFullName() + ": " + person4.getYearsSinceDeath() + " years");
        }

        System.out.println("Age " + person1.getFullName() + ": " + person1.getAge() + " years");

        if (person1.isAlive()) {
            System.out.println(person1.getFullName() + " Alive.");
        } else {
            System.out.println("Died at " + person1.getDeathYear());
            System.out.println("Time since death " + person1.getFullName() + ": " + person1.getYearsSinceDeath() + " years");
        }
        System.out.println(person1.getAllInfo());

         */

        System.out.println("==== Family Tree ====");
        for (Person person : familyTree) {
            System.out.println("----------------------------");
            System.out.println("Name: " + person.getFullName());
            System.out.println("Model.Gender: " + person.getGender());
            System.out.println("Birth Date: " + person.getBirthDate());
            System.out.println("Death Date: " + person.getDeathYear());
            if (person.isAlive()) {
                System.out.println("Age: " + person.getAge() + " years (Alive)");
            } else {
                System.out.println("Age: " + person.getAge() + " years (Died " + person.getYearsSinceDeath() + " years ago)");
            }
            System.out.println("Relationships:");
            for (Relationship relationship : person.getRelationships()) {
                System.out.println("  " + relationship.getType() + ": " + relationship.getPerson2().getFullName());
            }
        }


        List<Person> peopleList = new ArrayList<>(List.of(person1, person2, person3, person4));
        FamilyTree familyTreeSorting = new FamilyTree(peopleList);

        familyTreeSorting.sortByName();

        System.out.println("==== Family Tree Sorted by Name ====");
        for (Person person : familyTreeSorting) {
            System.out.println("----------------------------");
            System.out.println("Name: " + person.getFullName());
            // ... (output other information)
        }

        System.out.println("\nSorting Family Tree by Birth Date...");
        familyTreeSorting.sortByBirthDate();

        System.out.println("\n==== Family Tree Sorted by Birth Date ====");
        for (Person person : familyTreeSorting) {
            System.out.println("----------------------------");
            System.out.println("Name: " + person.getFullName());
            System.out.println("Birth Date: " + person.getBirthDate());
            // ... (output other information)
        }


    }

}
