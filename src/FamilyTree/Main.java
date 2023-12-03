package FamilyTree;
import FamilyTree.model.Person.Gender;
import FamilyTree.model.Person.Person;
import FamilyTree.model.Person.PersonBuilder;
import FamilyTree.model.Service.FileHandler;
import FamilyTree.model.Service.Service;
import FamilyTree.view.ConsoleUI;
import FamilyTree.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();


//        // Создание генеалогического дерева с корневым человеком person1
//        Service myTree = new Service("Romanov");
//        PersonBuilder builder = new PersonBuilder();
//
//        Person per1 = builder.build("Sveta", "Romanova", Gender.woman, LocalDate.of(1989, 10, 2));
//        Person per2 = builder.build("Petr", "Romanov", Gender.man, LocalDate.of(1988, 1, 15));
//        per1.setMarriage(per2, LocalDate.of(2010, 11, 12));
//        per2.setMarriage(per1, LocalDate.of(2010, 11, 12));
//
//        myTree.addPerson(per1);
//        myTree.addPerson(per2);
//
//        Person ch1 = builder.build("Ivan", "Romanov", Gender.man, LocalDate.of(2020, 4, 11), per1, per2);
//        myTree.addChild(ch1);
//
//        myTree.sortByName();
//        myTree.sortByAge();
//
//        System.out.println(myTree);
//


    }
}