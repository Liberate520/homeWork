import family_tree.FamilyTree;
import human.Human;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human h1 = new Human("Галина", "Гусина", LocalDate.of(1961, 4, 17), null, null, null);
        Human h2 = new Human("Вячеслав", "Гусин", LocalDate.of(1959, 6, 25), null, null, null);
        Human h3 = new Human("Сергей", "Гусин", LocalDate.of(1982, 12, 15), null, h1, h2);
        Human h4 = new Human("Евгения", "Петрова", LocalDate.of(1985, 9, 20), null, h1, h2);
        Human h5 = new Human("Александр", "Петров", LocalDate.of(2010, 5, 7), null, h4, null);

        Service service = new Service();
        service.addHuman(h1);
        service.addHuman(h2);
        service.addHuman(h3);
        service.addHuman(h4);
        service.addHuman(h5);

        System.out.println("--------------------------------");
        System.out.println("Фамильное дерево:");
        System.out.println(service.printHumanList());

        System.out.println("--------------------------------");
        System.out.println("Сортировка по имени");
        service.sortByFirstName();
        System.out.println(service.printHumanList());

        System.out.println("--------------------------------");
        System.out.println("Сортировка по фамилии");
        service.sortByLastName();
        System.out.println(service.printHumanList());

        System.out.println("--------------------------------");
        System.out.println("Сортировка по количеству детей");
        service.sortByChildrenCount();
        System.out.println(service.printHumanList());

//        FamilyTree familyTree = new FamilyTree();
//        String name = "Галина";
//        System.out.println("--------------------------------");
//        System.out.println("Поиск по имени:" + name);
//        String findHuman = familyTree.getHumanByName(name);
//        System.out.println(findHuman);
//
//        String year = "2010";
//        System.out.println("--------------------------------");
//        System.out.println("Поиск по дате рождения: " + year);
//        String findHumanByDate = familyTree.getHumanByBirthDate(year);
//        System.out.println(findHumanByDate);
//
//        System.out.println("--------------------------------");
//        System.out.println("Сколько лет человеку:");
//        System.out.println(h4.getInfo());
//        System.out.println(h4.getHumanYearsOld());

//        file_handler.FileHandler fileHandler = new file_handler.FileHandler();
//        fileHandler.save(familyTree);
//        System.out.println("--------------------------------");
//        System.out.println("--------------------------------");
//        System.out.println("Фамильное дерево:");
//        System.out.println(fileHandler.load().getHumanList());
    }
}
