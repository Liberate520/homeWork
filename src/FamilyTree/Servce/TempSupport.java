package family_tree.FamilyTree.Servce;
import family_tree.FamilyTree.Tree.FamilyTree;
import family_tree.FamilyTree.Tree.FileManager;
import family_tree.FamilyTree.Person.Gender;
import family_tree.FamilyTree.Person.Person;

import java.io.IOException;
import java.time.LocalDate;

public class TempSupport {

    //TODO временно вспомогательное. разберу кучу позже - не понимаю почему файл регулярно не читается
    public static void manualVariant() throws IOException {
        FamilyTree my_tree = new FamilyTree();

        my_tree.addPerson(new Person("Ivanov", "Adam", Gender.Male, LocalDate.of(1979, 10, 12)));
        my_tree.addPerson(new Person("Somova", "Eva", Gender.Female, LocalDate.of(1980, 5, 12)));
        my_tree.addPerson(new Person("Ivanova", "Tonya", Gender.Female, LocalDate.of(2020, 12, 25)));
        my_tree.addPerson(new Person("Ivanov", "Fima", Gender.Male, LocalDate.of(2022, 8, 15)));
//        System.out.println("list tree");
//        System.out.println(my_tree.getAllTreeStr());

//        System.out.println(my_tree.getForInn(4).getInfo());
        Person fater = my_tree.getForInn(1);
        Person moter = my_tree.getForInn(2);
        Person chilren = my_tree.getForInn(3);
        chilren.setParents(fater, moter);

        chilren = my_tree.getForInn(4);
        chilren.setParents(fater, moter);

        my_tree.marriage(moter, fater);

//        System.out.println("list tree");
//
//        System.out.println(my_tree.getAllTreeStr());
//
//        // получение данных о детях в список и вывод его на печать
//        System.out.println("\ndata about children: " + fater.getInfo());
//        for (Person item : fater.getChildren()) {
//            System.out.println(item.getFullInfo());
//        }
//        //получение данных о детях как готовая текстовая строка
//        System.out.println("\ndata about children: " + fater.getInfo());
//        System.out.println(fater.getListChildren());
//
        FileManager fileMyTree = new FileManager("new_tree.txt");
        // пишем в файл
        fileMyTree.write(my_tree);


    }

    //TODO временно вспомогательное
    public static void recoveryFile() throws IOException {
//        // достаем из файла
        FamilyTree doubleTree = new FamilyTree();
        //TODO 2й вариант запаковки/распаковки с использованием ObjectOutputStream и ObjectInputStream. можно ли оставить только этот вариант?
        FileManager test = new FileManager("test.txt");
        test.write(doubleTree); // записала в файл

        FamilyTree importTree = new FamilyTree();
        importTree = test.read(); // достала из файла.

        System.out.println("\n list tree: variant two ");
        for (String item : importTree.getFullInfoTree()) {
            System.out.println(item);
        }

    }
}
