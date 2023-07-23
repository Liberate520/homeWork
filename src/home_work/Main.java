package home_work;

import java.time.LocalDate;


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        FileHandler fileHandler = new FileHandler();
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Ivan", Gender.male, LocalDate.of(2000, 12, 17), LocalDate.of(2021, 12, 15));
        Human human2 = new Human("Sergey", Gender.male, LocalDate.of(2001, 12, 17));
        Human human3 = new Human("Misha", Gender.male, LocalDate.of(1950, 12, 17), LocalDate.of(2000, 12, 14));
        Human human4 = new Human("Anna", Gender.female, LocalDate.of(1985, 12, 17));
        Human human5 = new Human("Anton", Gender.male, LocalDate.of(2002, 12, 17));
        Human human6 = new Human("Masha", Gender.female, LocalDate.of(2014, 12, 17));
        Human human7 = new Human("Katya", Gender.female, LocalDate.of(1999, 12, 17));
        Human human8 = new Human("Petr", Gender.male, LocalDate.of(2000, 12, 17));

        // human1.addChildren(human8);
        // human8.addParent(human1);
        // human1.addChildren(human3);
        // human3.addParent(human1);
        // human5.addChildren(human2);
        // human2.addParent(human5);
        // human3.addChildren(human5);
        // human5.addParent(human3);
        // human3.addChildren(human6);
        // human6.addParent(human3);
        // human8.addChildren(human7);
        // human7.addParent(human8);
        // human7.addChildren(human4);
        // human4.addParent(human7);

        service.craateLink(human1, human8);
        service.craateLink(human1, human3);
        service.craateLink(human5, human2);
        service.craateLink(human3, human5);
        service.craateLink(human3, human6);
        service.craateLink(human8, human7);
        service.craateLink(human7, human4);

        service.createTree(human1);
        System.out.println(service.getInfo());
        service.sortByName();
        System.out.println(service.getInfo());
        service.sortByAge();
        System.out.println(service.getInfo());
        // familyTree.createTree(human1);
        // System.out.println(familyTree.getTree());

        // fileHandler.save(familyTree);
        // familyTree = (FamilyTree) fileHandler.load();
        // System.out.println(familyTree.getTree());

    }
}