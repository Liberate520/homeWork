package family_tree;

import java.time.LocalDate;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Person adamIvanov = new Person("Ivanov", "Adam", Gender.Male, LocalDate.of(1979, 10, 12));
        Person evaSomova = new Person("Somova","Eva",  Gender.Female, LocalDate.of(1980, 5, 12));



        Family_tree my_tree = new Family_tree();

        my_tree.addPerson(adamIvanov);

        my_tree.marriage(adamIvanov, evaSomova);

        Person tonyaIvanova = new Person("Ivanova", "Tonya", Gender.Female, LocalDate.of(2020,12,25));
        tonyaIvanova.setParents(adamIvanov, evaSomova);
        my_tree.addPerson(tonyaIvanova);

        Person fimaIvanov = new Person("Ivanov", "Fima", Gender.Male, LocalDate.of(2022,8,15));
        fimaIvanov.setParents(adamIvanov, evaSomova);
        my_tree.addPerson(fimaIvanov);


        //получение всех элементов дерева
        System.out.println("list tree");
        System.out.println(my_tree.getAllTreeStr());


        // получение данных о детях в список и вывод его на печать
        System.out.println("\ndata about children: " + adamIvanov.getInfo());
        for (Person item : adamIvanov.getChildren()){
            System.out.println(item.getFullInfo());
        }

        //получение данных о детях как готовая текстовая строка
        System.out.println("\ndata about children: " + adamIvanov.getInfo());
        System.out.println(adamIvanov.getListChildren());

    }


}
