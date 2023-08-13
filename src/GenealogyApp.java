import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GenealogyApp {
    public static void main(String[] args) {

        Person person1 = new Person(1,"John","Smith",Gender.MALE,LocalDate.of(1971,8,8),null);
        Person person2 = new Person(2,"Alise","Smith",Gender.FEMALE,LocalDate.of(1974,3,5),null);
        Person person3 = new Person(3,"Ann","Smith",Gender.FEMALE,LocalDate.of(1998,9,11),null);
        Person person4 = new Person(4,"Will","Smith",Gender.MALE,LocalDate.of(1901,1,2),LocalDate.of(1992,4,13));



        //TODO автоматизировать, меньше одинаковых строк

        Relationship spouseRelationship = new Relationship(person1, person2, RelationshipType.SPOUSE);
        Relationship childRelationship1 = new Relationship(person1, person3, RelationshipType.CHILD);
        Relationship childRelationship2 = new Relationship(person2, person3, RelationshipType.CHILD);
        Relationship fatherRelationship = new Relationship(person3, person1, RelationshipType.FATHER);
        Relationship motherRelationship = new Relationship(person3, person2, RelationshipType.MOTHER);
        Relationship fatherRelationship2 = new Relationship(person4, person1, RelationshipType.FATHER);

        person1.getRelationships().add(spouseRelationship);
        person2.getRelationships().add(spouseRelationship);
        person1.getRelationships().add(childRelationship1);
        person2.getRelationships().add(childRelationship2);
        person3.getRelationships().add(fatherRelationship);
        person3.getRelationships().add(motherRelationship);
        person1.getRelationships().add(fatherRelationship2);


        FamilyTree familyTree = new FamilyTree(List.of(person1,person2,person3,person4));


        List<Person> people = List.of(person1,person2,person3,person4);
        FamilyTreeFileManager fileManager = new FamilyTreeFileManager(people);
        try {
            // Сохранение древа семьи в файл
            fileManager.saveFamilyTree("family_tree.dat");

            // Загрузка древа семьи из файла
            fileManager.loadFamilyTree("family_tree.dat");

            // Доступ к данным
            List<Person> loadedPeople = fileManager.getPeople();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Relationship> allRelationships = familyTree.getAllRelationships();
        System.out.println(allRelationships);
        System.out.println(familyTree.getAllPeople());

        System.out.println("Age " + person4.getFullName() + ": " + person4.getAge() + " years");

        if (person4.isAlive()) {
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
    }

}