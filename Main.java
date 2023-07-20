package homeWork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.Provider.Service;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import homeWork.FamilyTree.FamilyTree;
import homeWork.gender.Gender;
import homeWork.human.Human;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        // FileHandler fileHandler = new FileHandler();
        // String filePath = "homeWork/fileHandler/tree.out";

        Human andrey = new Human("Андрей", Gender.Male, LocalDate.of(1980, 12, 30),
                43, 1);
        service.addHuman();
        Human maria = new Human("Мария", Gender.Female, LocalDate.of(1985, 9, 15), 38, 2);
        service.addHuman(maria);
        Human kristina = new Human("Кристина", Gender.Female, LocalDate.of(2008, 7, 5), 15, 3);
        service.addHuman(kristina);
        Human nikita = new Human("Никита", Gender.Male, LocalDate.of(2011, 1, 25), 12, 4);
        service.addHuman(nikita);

        System.out.println(service.getHumanInfo());

        // fileHandler.save(tree, "homeWork/fileHandler/tree.out");

        service.sortByName();
        System.out.println(service.getHumanInfo());
        service.sortByAge();
        System.out.println(service.getHumanInfo());

    }

}
