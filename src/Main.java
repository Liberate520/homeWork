import com.sun.source.tree.Tree;
import trees.TreeOfTrees;
import familyTree.FamilyTree;
import handler.FileHandler;
import person.Person;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Person Tom = new Person("Tom", "Geller", true, new GregorianCalendar(1955, 0, 20));
        Person Fred = new Person("Fred", "Geller", true);
        Person Misha = new Person("Misha", "Geller", true);
        Person Vanya = new Person("Vanya", "Geller", true);
        Person Nastya = new Person("Nastya", "York", false);
        Person Lora = new Person("Lora", "Argo", false);
        Person Masha = new Person("Masha", "Geller", false);
        Person Pavel = new Person("Pavel", "Geller", true);
        Tom.addChild(Fred);
        Tom.addChild(Vanya);
        Fred.addChild(Misha);
        Fred.addChild(Nastya);
        Vanya.addChild(Lora);
        Vanya.addChild(Masha);
        Misha.addChild(Pavel);
        Person Dasha = new Person(Masha);
        Dasha.setFirstName("Dasha");


        TreeOfTrees treeOfTrees = new TreeOfTrees();
        Service service = new Service(treeOfTrees);
        service.addFamilyTree(Tom);
        service.addFamilyTree("Smith");
        service.addPerson("Smith", "Laura", "Smith", false, new GregorianCalendar(1975, 11, 15));
        //service.findPerson("Laura").addChild(service.findPerson("Pavel"));

        //treeOfTrees.printAllInfo();

        FamilyTree myFamilyTree2 = new FamilyTree(Vanya);
        service.addFamilyTree(myFamilyTree2);
        treeOfTrees.printAllInfo();
        System.out.println();
        System.out.println();

        System.out.println("Сортировка по имени");
        service.sortByFirstName();
        treeOfTrees.printAllInfo();
        System.out.println();
        System.out.println();

        System.out.println("Сортировка по полу");
        service.sortByGender();
        treeOfTrees.printAllInfo();
        System.out.println();
        System.out.println();

        System.out.println("Сортировка по фамилии");
        service.sortByLastName();
        treeOfTrees.printAllInfo();

        /*System.out.println(service.findFamilyTree("Tom"));
        System.out.println(myFamilyTree2);*/

        /*FileHandler fileHandler = new FileHandler();
        treeOfTrees.save(fileHandler, "FamiliesTrees.txt");
        TreeOfTrees treeOfTrees2 = (TreeOfTrees) fileHandler.read("FamiliesTrees.txt");
        treeOfTrees2.printAllInfo();*/
    }
}