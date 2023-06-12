package presenter;

import model.Data;
import model.GroupItem;
import model.Lib;
import model.file.DataFileManager;
import model.person.Person;
import model.tree.Tree;

import java.io.IOException;

public class Presenter {

    protected Tree<Person> getData() {
        Tree<Person> ft = Data.dataEntry();
        return ft;
    }

    public void loadData() throws IOException, ClassNotFoundException {
        DataFileManager datafilemanager = new DataFileManager();
        Tree ft = (Tree) datafilemanager.loadData();
        Lib.printList(ft.getPersonList());
    }

    public void saveData() throws IOException {
        DataFileManager datafilemanager = new DataFileManager();
        datafilemanager.saveData(getData());
    }

    public void printSortByName() {
        Tree<Person> ft = getData();
        ft.sortByName();
        for (GroupItem person : ft) {
            System.out.println(person);
        }
        System.out.println();
    }

    public void printSortByDOB() {
        Tree<Person> ft = getData();
        ft.sortByDOB();
        for (GroupItem person : ft) {
            System.out.println(person);
        }
        System.out.println();
    }

}
