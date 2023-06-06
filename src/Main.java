import model.Data;
import model.GroupItem;
import model.Lib;
import model.file.DataFileManager;
import model.person.Person;
import model.tree.Tree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataFileManager datafilemanager = new DataFileManager();

        Tree<Person> ft = Data.dataEntry();                   // get initial data
        //datafilemanager.saveData(ft);                 // save data to file
        //Tree ft = (Tree)datafilemanager.loadData();     // load data from file


        System.out.println("\nЛица в генеалогическом дереве:");
        Lib.printList(ft.getPersonList());
        System.out.println();
        System.out.println("Папой для лица \"" + ft.findPersonByName("Стёпа") + "\" является:\n" +  ft.findPersonByName("Стёпа").getFather());
        System.out.println();
        System.out.println("Мамой для лица \"" + ft.findPersonByName("Алексей") + "\" является:\n" +  ft.findPersonByName("Алексей").getMother());
        System.out.println();
        System.out.println("Родителями для лица \"" + ft.findPersonByName("Стёпа") + "\" являются:");
        Lib.printList(ft.findPersonByName("Стёпа").getParents());
        System.out.println();
        System.out.println("Детьми для лица \"" + ft.findPersonByName("Татьяна") + "\" являются:");
        Lib.printList(ft.findPersonByName("Татьяна").getChildren());
        System.out.println("Братьями и сетстрами для лица \"" + ft.findPersonByName("Вика") + "\" являются:");
        Lib.printList(ft.findSiblings(ft.findPersonByName("Вика")));


        ft.sortByName();
        System.out.println("Сортировка по имени:");
        for (GroupItem person : ft) {
            System.out.println(person);
        }
        System.out.println();

        System.out.println("Сортировка по дате рождения:");
        ft.sortByDOB();
        for (GroupItem person : ft) {
            System.out.println(person);
        }

    }

}