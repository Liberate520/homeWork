package FamilyTree;
import FamilyTree.Person.Gender;
import FamilyTree.Person.Person;
import FamilyTree.Service.FileHandler;
import FamilyTree.Service.Service;
import FamilyTree.Tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Создание генеалогического дерева с корневым человеком person1
        Service myTree = new Service("Romanov");
        //FamilyTree familyTree = new FamilyTree();


        Person per1 = new Person("Sveta", "Romanova", Gender.woman, LocalDate.of(1989, 10, 2));
        Person per2 = new Person("Petr", "Romanov", Gender.man, LocalDate.of(1988, 1, 15));
        per1.setMarriage(per2, LocalDate.of(2010, 11, 12));
        per2.setMarriage(per1, LocalDate.of(2010, 11, 12));

        myTree.addMember(per1);
        myTree.addMember(per2);

        Person ch1 = new Person("Ivan", "Romanov", Gender.man, LocalDate.of(2020, 4, 11), per1, per2);
        myTree.addChild(ch1);


        myTree.sortByName();
        myTree.sortByAge();

        System.out.println(myTree);

        FileHandler fs = new FileHandler();
        fs.write(myTree, "test.bin");



        Service testTree = null;
        try {
            testTree = (Service) fs.read("test.bin");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}