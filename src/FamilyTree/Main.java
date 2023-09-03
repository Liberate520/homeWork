package family_tree.FamilyTree;

import family_tree.FamilyTree.Model.Person.Gender;
import family_tree.FamilyTree.Model.Person.Person;
import family_tree.FamilyTree.Model.Servce.Service;
import family_tree.FamilyTree.Model.Tree.FamilyTree;
import family_tree.FamilyTree.Model.Tree.FileManager;
import family_tree.FamilyTree.View.ConsoleUI;
import family_tree.FamilyTree.View.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) throws IOException {

        View view = new ConsoleUI();
        view.start();

//        Service service = new Service();
//
//        service.extractFromFile("archvetree.txt");

//        service.addPerson("Ivanov", "Adam", Gender.Male, LocalDate.of(1979, 10, 12));
//        service.addPerson("Somova", "Eva", Gender.Female, LocalDate.of(1980, 5, 12));
//        service.addPerson("Ivanova", "Tonya", Gender.Female, LocalDate.of(2020, 12, 25));
//        service.addPerson("Ivanov", "Fima", Gender.Male, LocalDate.of(2022, 8, 15));


//        System.out.println(service.getListInfo());
//        service.marriageForINN(0, 1);
//        service.setParentsForINN(2, 1);
//        service.setParentsForINN(2, 0);
//        service.setParentsForINN(3, 0);
//        service.setParentsForINN(3, 1);
//        service.sortByAge();
//
//        System.out.println("----");
//        System.out.println(service.getListInfo());

//        service.archiveToFile("archvetree.txt");


    }

}
