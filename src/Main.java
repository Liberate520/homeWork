import model.Service;
import model.famyilyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.makeFiles.MakeFiles;
import presenter.Presenter;
import view.Console;
import view.View;

import java.time.LocalDate;
import java.util.logging.FileHandler;

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
                LocalDate.of(1999, 3, 8),
                service.getFamilyGroup().getById(1), service.getFamilyGroup().getById(2));

        service.addHuman("Светлана", "Свиридова", Gender.Female,
                LocalDate.of(2023, 8, 18),
                 service.getFamilyGroup().getById(1),service.getFamilyGroup().getById(2));


        //System.out.println(someFamily.getInfo());

        service.readFromFile();
        View view = new Console();
        Presenter presenter = new Presenter(view, service);

        view.start();

//        //---- Сериализация
//        serial.saveToFile(someFamily, filename);
//
//        //---- Прочитать из файла
//        service.readFromFile();
//
//        System.out.println(tree2.getInfo());
//
//        System.out.println(someFamily.equals(tree2));

//        service.sortByLastName();
//        System.out.println(someFamily.getInfo());
//
//        service.sortByID();
//        System.out.println(someFamily.getInfo());
    }
}

