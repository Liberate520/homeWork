
import java.time.LocalDate;

import fileWork.FilehandlerOS;
import fileWork.FilehandlerTXT;
import fileWork.Filename;
import fileWork.Writeable;
import group.FamilyTree;
import group.Groupable;
import person.Gender;
import person.Person;
import presenter.Presenter;
import service.Service;
import view.Console;
import view.View;


public class Main {
    public static void main(String[] args) {
        Groupable<Person> familyTree = new FamilyTree<>();
        View view = new Console();
        Service service = new Service(familyTree);
        Presenter presenter = new Presenter(view, service);
        view.start();
   

        //   familyTree.addPerson(new Person(1, "Авилова Клавдия", LocalDate.of(1922, 10, 14),
        //                         LocalDate.of(2009, 05, 10),
        //                         Gender.female, null, null, null));

        //         familyTree.addPerson(new Person(2, "Мишина Надежда", LocalDate.of(1957, 3, 25),
        //                         null, Gender.female, familyTree.getPersonByName("Авилова Клавдия"), null,
        //                         null));

        //         familyTree.addPerson(new Person(3, "Мишин Анатолий", LocalDate.of(1957, 8, 02),
        //                         null, Gender.male, null, null,
        //                         null));

        //         familyTree.addPerson(new Person(4, "Мишина Олеся", LocalDate.of(1979, 9, 14),
        //                         null, Gender.female, familyTree.getPersonByName("Мишина Надежда"),
        //                         familyTree.getPersonByName("Мишин Анатолий"),
        //                         null));

        //         familyTree.addPerson(new Person(5, "Мишина Дарья", LocalDate.of(1987, 04, 02),
        //                         null, Gender.female, familyTree.getPersonByName("Мишина Надежда"),
        //                         familyTree.getPersonByName("Мишин Анатолий"),
        //                         null));

        //         familyTree.addPerson(new Person(6, "Вяткин Алексей", LocalDate.of(1975, 7, 1),
        //                         null, Gender.male, null, null,
        //                         null));

        //         familyTree.addPerson(new Person(7, "Вяткин Константин", LocalDate.of(2010, 8,
        //                         11), null, Gender.male, familyTree.getPersonByName("Мишина Олеся"),
        //                         familyTree.getPersonByName("Вяткин Алексей"),
        //                         null));
        //         familyTree.addPerson(new Person(8, "Вяткин Кирилл", LocalDate.of(2013, 7,
        //                         28),
        //                         null, Gender.male, familyTree.getPersonByName("Мишина Олеся"),
        //                         familyTree.getPersonByName("Вяткин Алексей"),
        //                         null));

        //                         String filenameOS = "FamilyTree.dat";
        //                         String filenameTXT = "FamilyTree.txt";
        //                         Writeable<Person> fileOS = new FilehandlerOS<>();
        //                         Writeable<Person> fileTXT = new FilehandlerTXT<>();
        //                         fileTXT.SaveToFile(familyTree, filenameTXT);
        //                         fileOS.SaveToFile(familyTree, filenameOS);
    }
}


      