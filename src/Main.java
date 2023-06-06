import model.Data;
import model.file.DataFileManager;
import model.person.Person;
import model.tree.Tree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataFileManager datafilemanager = new DataFileManager();
        Tree ft = Data.dataEntry();                   // get initial data
        //datafilemanager.saveData(ft);                 // save data to file
        //model.tree.Tree ft = (model.tree.Tree)datafilemanager.loadData();     // load data from file

        /*
        System.out.println("\nЛица в генеалогическом дереве:");
        model.Lib.printList(ft.getPersonList());
        System.out.println();
        System.out.println("Папой для лица \"" + ft.findPersonByName("Степан") + "\" является:\n" +  ft.findPersonByName("Степан").getFather());
        System.out.println();
        System.out.println("Мамой для лица \"" + ft.findPersonByName("Алексей") + "\" является:\n" +  ft.findPersonByName("Алексей").getMother());
        System.out.println();
        System.out.println("Родителями для лица \"" + ft.findPersonByName("Степан") + "\" являются:");
        model.Lib.printList(ft.findPersonByName("Степан").getParents());
        System.out.println();
        System.out.println("Детьми для лица \"" + ft.findPersonByName("Татьяна") + "\" являются:");
        model.Lib.printList(ft.findPersonByName("Татьяна").getChildren());
        System.out.println("Братьями и сетстрами для лица \"" + ft.findPersonByName("Вика") + "\" являются:");
        model.Lib.printList(ft.findSiblings(ft.findPersonByName("Вика")));
        */

        ft.sortByName();
        System.out.println("Сортировка по имени:");
        for (Person person : ft) {
            System.out.println(person);
        }
        System.out.println();

        System.out.println("Сортировка по дате рождения:");
        ft.sortByDOB();
        for (Person person : ft) {
            System.out.println(person);
        }

    }

}