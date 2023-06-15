package model.service;

import model.Data;
import model.GroupItem;
import model.person.Person;
import model.tree.Tree;

import java.util.List;

public class PrintService {
    public static void printList(List<Person> someList) {
        StringBuilder someString = new StringBuilder();
        for (Person item : someList) {
            someString.append(item);
            someString.append("\n");
        }
        System.out.println(someString);
    }

    public void printSortByName() {
        Tree<Person> ft = Data.getData();
        ft.sortByName();
        for (GroupItem person : ft) {
            System.out.println(person);
        }
        System.out.println();
    }

    public void printSortByDOB() {
        Tree<Person> ft = Data.getData();
        ft.sortByDOB();
        for (GroupItem person : ft) {
            System.out.println(person);
        }
        System.out.println();
    }

}
