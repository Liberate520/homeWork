import model.Data;
import model.GroupItem;
import model.Lib;
import model.file.DataFileManager;
import model.person.Person;
import model.tree.Tree;
import view.ConsoleUI;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        view.start();
    }
}