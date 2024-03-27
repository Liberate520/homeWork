package tree;

import writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Добавляем людей в дерево
        Person person1 = new Person("John", Gender.Male, LocalDate.of(1950, 05, 30));
        Person person2 = new Person("Jane", Gender.Female, LocalDate.of(1952, 02, 15));
        Person person3 = new Person("Tom", Gender.Male, LocalDate.of(1960, 04, 2));
        Person person4 = new Person("Emily", Gender.Female, LocalDate.of(1990, 8, 5));
        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);
        familyTree.addPerson(person4);

        // Добавляем отношения в дерево
        familyTree.addRelationship("John", "Tom");
        familyTree.addRelationship("Jane", "Tom");
        familyTree.addRelationship("John", "Emily");
        familyTree.addRelationship("Jane", "Emily");

//        // Получаем всех детей выбранного человека
//        List<Person> children = familyTree.getChildrenOfPerson("John");
//        System.out.println("Children of John:");
//        for (Person child : children) {
//            System.out.println(child);
//        }
//        System.out.println(familyTree);

        for(Person person: familyTree){
            System.out.println(person.toString());
        }

        FileHandler handler = new FileHandler();
        handler.save(familyTree);
    }
}
