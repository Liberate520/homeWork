import famyilyTree.FamilyTree;
import human.Gender;
import human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        String filename = "data.txt";
//        Serial serial = new Serial();
        FamilyTree<Human> someFamily = new FamilyTree<>();
        Service service = new Service(someFamily);

        service.addHuman("Никита", "Свиридов", Gender.Male,
                LocalDate.of(1968, 1, 15));

        service.addHuman("Ирина", "Андреева", Gender.Female,
                LocalDate.of(1970, 8, 13));

        service.addHuman("Павел", "Свиридов", Gender.Male,
                LocalDate.of(19, 3, 8),
                service.getFamilyGroup().getById(1), service.getFamilyGroup().getById(2));

        service.addHuman("Светлана", "Свиридова", Gender.Female,
                LocalDate.of(2023, 8, 18),
                 service.getFamilyGroup().getById(1),service.getFamilyGroup().getById(2));


        System.out.println(someFamily.getInfo());

//        //---- Сериализация
//        serial.saveToFile(someFamily, filename);
//
//        //---- Десериализация
//        FamilyTree tree2 = serial.loadFromFile(filename);
//
//        System.out.println(tree2.getInfo());
//
//        System.out.println(someFamily.equals(tree2));

        service.sortByLastName();
        System.out.println(someFamily.getInfo());

        service.sortByID();
        System.out.println(someFamily.getInfo());
    }
}

