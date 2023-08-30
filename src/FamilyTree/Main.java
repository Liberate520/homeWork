package family_tree.FamilyTree;

import family_tree.FamilyTree.Person.Person;
import family_tree.FamilyTree.Servce.TempSupport;
import family_tree.FamilyTree.Tree.FamilyTree;
import family_tree.FamilyTree.Tree.FileManager;

import java.io.IOException;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) throws IOException {

        //TempSupport.manualFill("tree_archive.txt");
        // достаем из файла
        FamilyTree <Person> myTree = new FamilyTree();

        FileManager arhiveFTree = new FileManager("tree_archive.txt");
        myTree = arhiveFTree.read(); // достала из файла.

        Iterator<Person> iterator = myTree.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getFullName());
        }

        myTree.sortByName();

        System.out.println("\nsort by last name");
        for (Person item : myTree) {
            System.out.println(item.getFullName());
        }


        myTree.sortByAge();

        System.out.println("\nsort by Age");
        for (Person item : myTree) {
            System.out.println(item.getFullName() + " - " + item.getDataBirth());
        }


    }

}
