package view;

import model.GroupItem;
import model.person.Person;
import model.tree.Tree;

import java.util.List;

public class PrintData {
    public static void printList(List<Person> someList) {
        StringBuilder someString = new StringBuilder();
        for (Person item : someList) {
            someString.append(item);
            someString.append("\n");
        }
        System.out.println(someString);
    }

    public static void printTree(Tree<Person> tree){
        for (GroupItem person : tree) {
            System.out.println(person);
        }
        System.out.println();
    }
}
