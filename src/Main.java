import familyTreeApi.Service;
import familyTreeApi.trees.TOTrees;
import familyTreeApi.familyTree.FamilyTree;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.View;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        Service service = new Service();
        Presenter presenter = new Presenter(view, service);

        view.start();

//        service.addFamilyTree("Person", "Geller");
//        service.addFamilyTree("Dog", "Smith");
//
//        service.addMember("Geller", "Tom", "Geller", true, new GregorianCalendar(1955, 0, 2));
//        service.addMember("Geller", "Fred", "Geller", true, new GregorianCalendar(1975, 1, 11));
//        service.addMember("Geller", "Misha", "Geller", true, new GregorianCalendar(1995, 3, 8));
//        service.addMember("Geller", "Vanya", "Geller", true, new GregorianCalendar(1977, 2, 26));
//        service.addMember("Geller", "Nastya", "York", false, new GregorianCalendar(1997, 6, 20));
//        service.addMember("Geller", "Lora", "Argo", false, new GregorianCalendar(1996, 8, 31));
//        service.addMember("Geller", "Masha", "Geller", false, new GregorianCalendar(1998, 9, 30));
//        service.addMember("Geller", "Pavel", "Smith-Geller", true, new GregorianCalendar(2016, 11, 7));
//
//        service.addChild("Geller", "Tom", "Fred");
//        service.addChild("Geller", "Tom", "Vanya");
//        service.addChild("Geller", "Fred", "Misha");
//        service.addChild("Geller", "Fred", "Nastya");
//        service.addChild("Geller", "Vanya", "Lora");
//        service.addChild("Geller", "Vanya", "Masha");
//        service.addChild("Geller", "Misha", "Pavel");
//
//        service.addMember("Geller", "Dasha", "Masha");
//
//
//        service.addMember("Smith", "Laura", "Smith", false, new GregorianCalendar(1997, 11, 15));
//        service.addMember("Smith", service.findMember("Pavel"));
//        service.addChild("Smith", "Laura", "Pavel");
//
//        //service.addMember("Geller", service.findPerson("Laura"));
//        service.addMember("Smith", service.findMember("Misha"));
//        //service.addMarried("Laura", "Misha", true);
//
//        service.printInfo();
//        service.printTrees();
//        System.out.println();
//        System.out.println();
//
//        System.out.println("Сортировка по имени");
//        service.sortByFirstName();
//        service.printInfo();
//        System.out.println();
//        System.out.println();
//
//        System.out.println("Сортировка по полу");
//        service.sortByGender();
//        service.printInfo();
//        System.out.println();
//        System.out.println();
//
//        System.out.println("Сортировка по фамилии");
//        service.sortByLastName();
//        service.printInfo();
//        System.out.println();
//        System.out.println();
//
//        service.save("FamiliesTrees.txt");
//        TOTrees<FamilyTree> treeOfTrees2 = service.read("FamiliesTrees.txt");
//        Service service2 = new Service(treeOfTrees2);
//        System.out.println("Восстановленное из файла:");
//        service2.printInfo();
//        System.out.println();
//        System.out.println();
//
//        System.out.println("Сортировка по имени");
//        service2.sortByFirstName();
//        service2.printInfo();
    }
}