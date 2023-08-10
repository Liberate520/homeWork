package family_tree;

import java.io.IOException;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) throws IOException {
//        manualVariant();
        recoveryFile();

    }
    public static void recoveryFile() throws IOException {
        // достаем из файла
        FileManager fileMyTree = new FileManager("my_tree.txt");
        Family_tree doubleTree = new Family_tree();
        doubleTree.fillInFile(fileMyTree.readInFile());

        System.out.println("list tree");
        System.out.println(doubleTree.getAllTreeStr(false));


    }

    public static void manualVariant() throws IOException {
        Family_tree my_tree = new Family_tree();


        my_tree.addPerson(new Person("Ivanov", "Adam", Gender.Male, LocalDate.of(1979, 10, 12)));
        my_tree.addPerson(new Person("Somova", "Eva", Gender.Female, LocalDate.of(1980, 5, 12)));
        my_tree.addPerson(new Person("Ivanova", "Tonya", Gender.Female, LocalDate.of(2020, 12, 25)));
        my_tree.addPerson(new Person("Ivanov", "Fima", Gender.Male, LocalDate.of(2022, 8, 15)));
        System.out.println("list tree");
        System.out.println(my_tree.getAllTreeStr(false));

        System.out.println(my_tree.getForInn(4).getInfo());
        Person fater = my_tree.getForInn(1);
        Person moter = my_tree.getForInn(2);
        Person chilren = my_tree.getForInn(3);
        chilren.setParents(fater, moter);

        chilren = my_tree.getForInn(4);
        chilren.setParents(fater, moter);

        my_tree.marriage(moter, fater);

        System.out.println("list tree");
        System.out.println(my_tree.getAllTreeStr(false));

        // получение данных о детях в список и вывод его на печать
        System.out.println("\ndata about children: " + fater.getInfo());
        for (Person item : fater.getChildren()) {
            System.out.println(item.getFullInfo());
        }
        //        //получение данных о детях как готовая текстовая строка
        System.out.println("\ndata about children: " + fater.getInfo());
        System.out.println(fater.getListChildren());

        FileManager fileMyTree = new FileManager("my_tree.txt");
        // пишем в файл
        fileMyTree.writeToFile(my_tree.getAllTreeStr(true));

    }


}
