package App;

import Fileworks.FamilyTreeFileManager;
import Model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GenealogyApp {
    public static void main(String[] args) {

        Person familyMember1 = new Person(1,"John","Smith",Gender.MALE,LocalDate.of(1971,8,8),null);
        Person familyMember2 = new Person(2,"Alise","Smith", Gender.FEMALE,LocalDate.of(1974,3,5),null);
        Person familyMember3 = new Person(3,"Ann","Smith",Gender.FEMALE,LocalDate.of(1998,9,11),null);
        Person familyMember4 = new Person(4,"Will","Smith",Gender.MALE,LocalDate.of(1901,1,2),LocalDate.of(1992,4,13));

        Relationship spouseRelationship = new Relationship(familyMember1, familyMember2, RelationshipType.SPOUSE);
        Relationship fatherRelationship = new Relationship(familyMember3, familyMember1, RelationshipType.FATHER);
        Relationship motherRelationship = new Relationship(familyMember3, familyMember2, RelationshipType.MOTHER);
        Relationship childRelationship1 = new Relationship(familyMember1, familyMember3, RelationshipType.CHILD);
        Relationship childRelationship2 = new Relationship(familyMember2, familyMember3, RelationshipType.CHILD);
        Relationship fatherRelationship2 = new Relationship(familyMember4, familyMember1, RelationshipType.FATHER);

// Automate relationship adding
        familyMember1.addRelationship(spouseRelationship);
        familyMember2.addRelationship(spouseRelationship);
        familyMember1.addRelationship(childRelationship1);
        familyMember2.addRelationship(childRelationship2);
        familyMember3.addRelationship(fatherRelationship);
        familyMember3.addRelationship(motherRelationship);
        familyMember1.addRelationship(fatherRelationship2);


        FamilyTree familyTree = new FamilyTree(List.of(familyMember1, familyMember2, familyMember3, familyMember4));

        List<FamilyMember> people = List.of(familyMember1, familyMember2, familyMember3, familyMember4);
        FamilyTreeFileManager fileManager = new FamilyTreeFileManager(people);
        try {
            /*Save and load family tree from file*/
           fileManager.saveFamilyTree("family_tree.dat");
           fileManager.loadFamilyTree("family_tree.dat");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            fileManager.loadFamilyTree("family_tree.dat");

            List<Relationship> allRelationships = familyTree.getAllRelationships();
            List<FamilyMember> allPeople = familyTree.getAllPeople();

            // Вывод информации о загруженных отношениях и людях
            System.out.println("All Relationships:");
            for (Relationship relationship : allRelationships) {
                System.out.println(relationship);
            }

            System.out.println("All People:");
            for (FamilyMember familyMember : allPeople) {
                System.out.println(familyMember);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


//        List<Model.Relationship> allRelationships = familyTree.getAllRelationships();
//        System.out.println(allRelationships);
//        System.out.println(familyTree.getAllPeople());

        System.out.println("Age " + familyMember4.getFullName() + ": " + familyMember4.getAge() + " years");

        /*if (familyMember4.isAlive()) {
            System.out.println(familyMember4.getFullName() + " Alive.");
        } else {
            System.out.println("Died at " + familyMember4.getDeathYear());
            System.out.println("Time since death " + familyMember4.getFullName() + ": " + familyMember4.getYearsSinceDeath() + " years");
        }

        System.out.println("Age " + familyMember1.getFullName() + ": " + familyMember1.getAge() + " years");

        if (familyMember1.isAlive()) {
            System.out.println(familyMember1.getFullName() + " Alive.");
        } else {
            System.out.println("Died at " + familyMember1.getDeathYear());
            System.out.println("Time since death " + familyMember1.getFullName() + ": " + familyMember1.getYearsSinceDeath() + " years");
        }
        System.out.println(familyMember1.getAllInfo());

         */

        System.out.println("==== Family Tree ====");
        for (FamilyMember familyMember : familyTree) {
            System.out.println("----------------------------");
            System.out.println("Name: " + familyMember.getFullName());
            System.out.println("Gender: " + familyMember.getGender());
            System.out.println("Birth Date: " + familyMember.getBirthDate());
            System.out.println("Death Date: " + familyMember.getDeathYear());

            if (familyMember.isAlive()) {
                System.out.println("Age: " + familyMember.getAge() + " years (Alive)");
            } else {
                System.out.println("Age: " + familyMember.getAge() + " years (Died " + familyMember.getYearsSinceDeath() + " years ago)");
            }

            System.out.println("Relationships:");
            for (Relationship relationship : familyMember.getRelationships()) {
                FamilyMember relatedFamilyMember = (relationship.getPerson1() == familyMember) ? relationship.getPerson2() : relationship.getPerson1();
                System.out.println("  " + relationship.getType() + ": " + relatedFamilyMember.getFullName());
            }
        }



        List<FamilyMember> peopleList = new ArrayList<>(List.of(familyMember1, familyMember2, familyMember3, familyMember4));
        FamilyTree familyTreeSorting = new FamilyTree(peopleList);

        familyTreeSorting.sortByName();

        System.out.println("==== Family Tree Sorted by Name ====");
        for (FamilyMember familyMember : familyTreeSorting) {
            System.out.println("----------------------------");
            System.out.println("Name: " + familyMember.getFullName());
            // ... (output other information)
        }

        System.out.println("\nSorting Family Tree by Birth Date...");
        familyTreeSorting.sortByBirthDate();

        System.out.println("\n==== Family Tree Sorted by Birth Date ====");
        for (FamilyMember familyMember : familyTreeSorting) {
            System.out.println("----------------------------");
            System.out.println("Name: " + familyMember.getFullName());
            System.out.println("Birth Date: " + familyMember.getBirthDate());
            // ... (output other information)
        }


    }

}
