package presenter;

import model.Data;
import model.GroupItem;
import model.file.DataFileManager;
import model.person.Person;
import model.tree.Tree;

import java.io.IOException;

public class Presenter {

    protected Tree<Person> getData() {
        Tree<Person> ft = Data.dataEntry();
        return ft;
    }

    public void saveData() throws IOException {
        DataFileManager datafilemanager = new DataFileManager();
        datafilemanager.saveData(getData());
    }

    public Tree<Person> loadData() throws IOException, ClassNotFoundException {
        DataFileManager datafilemanager = new DataFileManager();
        Tree ft = (Tree) datafilemanager.loadData();
        return ft;
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
