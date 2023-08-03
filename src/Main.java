import models.Human;
import models.familyTree.FamilyTree;

import java.time.LocalDate;

import static models.Gender.FEMALE;
import static models.Gender.MALE;
import static models.Roles.*;

public class Main {
    public static void main(String[] args) {
        FamilyService service = new FamilyService(new FamilyTree());
        Human newHuman = new Human("Pavel", "Kuznetsov", MALE, LocalDate.of(1990, 5, 12));
        service.createNewFamily(newHuman);

        Human newHumanMother = new Human("Svetlana", "Ivanova", FEMALE, LocalDate.of(1993, 10, 11));
        Human newHumanDaughter = new Human("Irina", "Kuznetsova", FEMALE, LocalDate.of(2010, 8, 5));
        Human newHumanSon = new Human("Ivan", "Kuznetsov", MALE, LocalDate.of(2020, 4, 30));

        service.addMemberToFamily(newHuman, newHumanMother, MOTHER);
        service.addMemberToFamily(newHuman, newHumanDaughter, DAUGHTER);
        service.addMemberToFamily(newHuman, newHumanSon, SON);

        Human newHuman2 = new Human("Anton", "Petrov", MALE, LocalDate.of(2008, 10, 27));
        Human newHuman2Daughter = new Human("Alina", "Petrova", FEMALE, LocalDate.of(2022, 1, 15));

        service.createNewFamily(newHuman2);
        service.addMemberToFamily(newHuman2, newHumanDaughter, MOTHER);
        service.addMemberToFamily(newHuman2, newHuman2Daughter, DAUGHTER);

        service.printPrimaryFamily(newHuman);
        System.out.println();
        service.printPrimaryFamily(newHuman2);
        service.getChildren(newHuman).forEach(System.out::println);
        System.out.println();
        service.getParents(newHumanDaughter).forEach(System.out::println);
    }
}
