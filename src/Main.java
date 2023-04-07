import trees.TOTrees;
import trees.TreeOfTrees;
import familyTree.FamilyTree;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        TOTrees<FamilyTree> treeOfTrees = new TreeOfTrees<>();
        Service service = new Service(treeOfTrees);
        service.addFamilyTree("Geller");
        service.addFamilyTree("Smith");

        service.addPerson("Geller", "Tom", "Geller", true, new GregorianCalendar(1955, 0, 2));
        service.addPerson("Geller", "Fred", "Geller", true, new GregorianCalendar(1975, 1, 11));
        service.addPerson("Geller", "Misha", "Geller", true, new GregorianCalendar(1995, 3, 8));
        service.addPerson("Geller", "Vanya", "Geller", true, new GregorianCalendar(1977, 2, 26));
        service.addPerson("Geller", "Nastya", "York", false, new GregorianCalendar(1997, 6, 20));
        service.addPerson("Geller", "Lora", "Argo", false, new GregorianCalendar(1996, 8, 31));
        service.addPerson("Geller", "Masha", "Geller", false, new GregorianCalendar(1998, 9, 30));
        service.addPerson("Geller", "Pavel", "Smith-Geller", true, new GregorianCalendar(2016, 11, 7));

        service.addChild("Geller", "Tom", "Fred");
        service.addChild("Geller", "Tom", "Vanya");
        service.addChild("Geller", "Fred", "Misha");
        service.addChild("Geller", "Fred", "Nastya");
        service.addChild("Geller", "Vanya", "Lora");
        service.addChild("Geller", "Vanya", "Masha");
        service.addChild("Geller", "Misha", "Pavel");

        service.addPerson("Geller", "Dasha", "Masha");


        service.addPerson("Smith", "Laura", "Smith", false, new GregorianCalendar(1997, 11, 15));
        service.addPerson("Smith", service.findPerson("Pavel"));
        service.addChild("Smith", "Laura", "Pavel");

        //service.addPerson("Geller", service.findPerson("Laura"));
        service.addPerson("Smith", service.findPerson("Misha"));
        //service.addMarried("Laura", "Misha", true);

        service.printInfo();
        System.out.println();
        System.out.println();

        System.out.println("Сортировка по имени");
        service.sortByFirstName();
        service.printInfo();
        System.out.println();
        System.out.println();

        System.out.println("Сортировка по полу");
        service.sortByGender();
        service.printInfo();
        System.out.println();
        System.out.println();

        System.out.println("Сортировка по фамилии");
        service.sortByLastName();
        service.printInfo();
        System.out.println();
        System.out.println();

        service.save("FamiliesTrees.txt");
        TOTrees<FamilyTree> treeOfTrees2 = service.read("FamiliesTrees.txt");
        Service service2 = new Service(treeOfTrees2);
        System.out.println("Восстановленное из файла:");
        service2.printInfo();
        System.out.println();
        System.out.println();

        System.out.println("Сортировка по имени");
        service2.sortByFirstName();
        service2.printInfo();
    }
}