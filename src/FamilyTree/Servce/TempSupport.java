package family_tree.FamilyTree.Servce;

import family_tree.FamilyTree.Tree.FamilyTree;
import family_tree.FamilyTree.Tree.FileManager;
import family_tree.FamilyTree.Person.Gender;
import family_tree.FamilyTree.Person.Person;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;

public class TempSupport {

    //TODO для формирования файла с деревом. почему-то файл регулярно не читается.
    public static void manualFill(String namefile) throws IOException {
        FamilyTree<Person> my_tree = new FamilyTree<>();

        my_tree.addPerson(new Person("Ivanov", "Adam", Gender.Male, LocalDate.of(1979, 10, 12)));
        my_tree.addPerson(new Person("Somova", "Eva", Gender.Female, LocalDate.of(1980, 5, 12)));
        my_tree.addPerson(new Person("Ivanova", "Tonya", Gender.Female, LocalDate.of(2020, 12, 25)));
        my_tree.addPerson(new Person("Ivanov", "Fima", Gender.Male, LocalDate.of(2022, 8, 15)));


        Person fater = my_tree.getForInn(1);
        Person moter = my_tree.getForInn(2);
        my_tree.marriage(moter, fater);

        Person chilren = my_tree.getForInn(3);
        chilren.setParents(fater, moter);

        chilren = my_tree.getForInn(4);
        chilren.setParents(fater, moter);


        Person granba = new Person("Popova", "Ksenia", Gender.Female, LocalDate.of(1958, 10, 2));
        my_tree.addPerson(granba);
        fater.addParent(granba);

        FileManager fileMyTree = new FileManager(namefile);
        // пишем в файл
        fileMyTree.write(my_tree);

    }

}
