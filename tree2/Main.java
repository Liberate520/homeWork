package homeWork.tree2;


import homeWork.tree2.familyTree.FamilyTree;
import homeWork.tree2.familyTree.services.Service;
import homeWork.tree2.tests.TestServiceClass;
import homeWork.tree2.human.Human;
import homeWork.tree2.tests.TestClass;

import java.time.LocalDate;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human[] people = new Human[10];

        people[0] = new Human("John", LocalDate.of(1950, 5, 15));
        people[1] = new Human("Elise", LocalDate.of(1951, 2, 11));
        people[2] = new Human("Mark", LocalDate.of(1974, 1, 11));
        people[3] = new Human("Iren", LocalDate.of(1976, 11, 7));
        people[4] = new Human("Nina", LocalDate.of(1998, 9, 9));
        people[5] = new Human("Artem", LocalDate.of(1999, 5, 5));
        people[6] = new Human("Jack", LocalDate.of(2010, 5, 12));
        people[7] = new Human("Jane", LocalDate.of(2012, 7, 12));
        people[8] = new Human("Alex", LocalDate.of(2014, 5, 15));
        people[9] = new Human("Soo", LocalDate.of(2017, 5, 30));


        people[3].setFather(people[1]);
        people[3].setMother(people[2]);
        people[3].getChildren().add(people[7]);
        people[3].getChildren().add(people[8]);

        people[5].setFather(people[3]);
        people[6].setMother(people[4]);
        people[7].getChildren().add(people[9]);


        FamilyTree<Human> familyTree = new FamilyTree<>();

        for (int i = 0; i < people.length; i++) {
            familyTree.addPeople(people[i]);
        }

        System.out.println("\n-------------Отрабатывает итератор-----------------------------------------\n");

        for (Human human : familyTree) {
            System.out.println(human.getName() + ": " + human.getAge() + " лет");
            System.out.println("Дети: " + human.getChildren());
        }


        Service service = new Service(familyTree);

        System.out.println("\n-------------Отрабатывает сортировка по имени--------------------------------\n");

        service.sortByName();
        for(Human human: familyTree){
            System.out.println(human.getName() + ": " + human.getAge() + " лет");
        }

        System.out.println("\n-------------Отрабатывает сортировка по возрасту-----------------------------\n");

        service.sortByAge();
        for(Human human: familyTree){
            System.out.println(human.getName() + ": " + human.getAge() + " лет");
        }


        System.out.println("\n-------------Создадим несколько экземпляров тестового класса-----------------\n");

        FamilyTree<TestClass> testCase = new FamilyTree<>();
        for(int i = 0; i < 5; i++){
            testCase.addPeople(new TestClass());
        }

        for(TestClass test: testCase){
            System.out.println(test.getName());
        }

        TestServiceClass TestService = new TestServiceClass(testCase);

        System.out.println("\n-------------Отрабатывает сортировка по имени--------------------------------\n");

        TestService.sortByParams();
        for(TestClass element: testCase){
            System.out.println(element.getName());
        }




    }


}
