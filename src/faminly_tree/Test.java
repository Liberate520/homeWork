package faminly_tree;

import faminly_tree.model.human.Gender;
import faminly_tree.model.human.Human;
import faminly_tree.model.save_in_file.SaveInFile;
import faminly_tree.model.tree.FamilyTree;
import faminly_tree.view.ConsoleUI;

import java.io.IOException;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }
}
