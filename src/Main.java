import ru.gb.f_tree.f_tree.FamilyTree;

import ru.gb.f_tree.human.Gender;
import ru.gb.f_tree.human.Human;
import ru.gb.f_tree.services.FamilyTreeService;

import java.time.LocalDate;
import java.util.List;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Создаем семью "Smith"
        FamilyTreeService familyTreeService = new FamilyTreeService("Smith");


        // Создаем некоторых людей
        Human willSmith = (Human) familyTreeService.addNewToFamily("Smith", "Will", Gender.Male);
        willSmith.setBirthday(LocalDate.of(1968, 9, 25));


        Human jadaPinkett = (Human) familyTreeService.addNewToFamily("Pinkett", "Jada", Gender.Female);
        jadaPinkett.setBirthday(LocalDate.of(1971, 9, 18));


        willSmith.setSpouse(jadaPinkett);

        Human jadenSmith = (Human) familyTreeService.addNewToFamily("Smith", "Jaden", Gender.Male);
        jadenSmith.setBirthday(LocalDate.of(1998, 7, 8));


        Human willowSmith = (Human) familyTreeService.addNewToFamily("Smith", "Willow", Gender.Female);
        willowSmith.setBirthday(LocalDate.of(2000, 10, 31));


        willSmith.setChild(jadenSmith);
        jadaPinkett.setChild(jadenSmith);
        willSmith.setChild(willowSmith);
        jadaPinkett.setChild(willowSmith);

        // Вывод информации о семье Smith
        System.out.println(familyTreeService);
        familyTreeService.sortFamilyMembers();
        System.out.println(familyTreeService);
        familyTreeService.sortFamilyMembers();
        System.out.println(familyTreeService);
        familyTreeService.sortFamilyMembers();
        System.out.println(familyTreeService);


        // Создаем еще одну семью "Jones"
        FamilyTreeService familyTreeService1 = new FamilyTreeService("Jones");

        Human tomJones = (Human) familyTreeService1.addNewToFamily("Jones", "Tom", Gender.Male);
        tomJones.setBirthday(LocalDate.of(1940, 6, 7));


        Human priscillaJones = (Human) familyTreeService1.addNewToFamily("Jones", "Priscilla", Gender.Female);
        priscillaJones.setBirthday(LocalDate.of(1945, 5, 24));


        tomJones.setSpouse(priscillaJones);

        Human elvisJones = (Human) familyTreeService1.addNewToFamily("Jones", "Elvis", Gender.Male);
        elvisJones.setBirthday(LocalDate.of(1971, 3, 15));


        tomJones.setChild(elvisJones);
        priscillaJones.setChild(elvisJones);

        //  Вывод информации о семье Jones
        System.out.println(familyTreeService1);
        familyTreeService.sortFamilyMembers();
        System.out.println(familyTreeService1);
        familyTreeService.sortFamilyMembers();
        System.out.println(familyTreeService1);
        familyTreeService.sortFamilyMembers();
        System.out.println(familyTreeService);

        }
    }

