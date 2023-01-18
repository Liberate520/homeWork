import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree myFamilyTree = new FamilyTree();
        Person person1 = new Person("Anna", 30, "female");
        Person person2 = new Person("Sergey", 31, "male");
        Person person3 = new Person("Andrey", 14, "male", person1, person2);
        Person person4 = new Person("Anna", 13, "female", person1, person2);
        Person person5 = new Person("Olga", 19, "female", person1);


        myFamilyTree.addPerson(person1);
        myFamilyTree.addPerson(person2);
        myFamilyTree.addPerson(person3);
        myFamilyTree.addPerson(person4);
        myFamilyTree.addPerson(person5);


        myFamilyTree.load();

        FileHandler fileHandler = new FileHandler();
        myFamilyTree.setWritable(fileHandler);
        myFamilyTree.save();


        Presenter presenter = new Presenter(myFamilyTree);
        UI ui = new UI(myFamilyTree, fileHandler, presenter);
        ui.start();





//        System.out.println();
//        System.out.println("Iterable persons from family tree: ");
//        for (Object person: myFamilyTree)
//            System.out.println(person);
//        System.out.println();
//
//        System.out.println("Sort by name: ");
//        myFamilyTree.sortByName();
//        for (Object person: myFamilyTree)
//            System.out.println(person);
//        System.out.println();





    }
}