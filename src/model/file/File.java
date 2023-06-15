package model.file;

import model.person.Person;
import model.tree.Tree;

import java.io.IOException;

public class File {
    public Tree loadData() throws IOException, ClassNotFoundException {
        DataFileManager datafilemanager = new DataFileManager();
        Tree ft = (Tree) datafilemanager.loadData();
        return ft;
    }

    public void saveData(Tree<Person> data) throws IOException {
        DataFileManager datafilemanager = new DataFileManager();
        datafilemanager.saveData(data);
    }
}
