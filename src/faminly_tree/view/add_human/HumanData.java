package faminly_tree.view.add_human;

import faminly_tree.model.human.Human;
import faminly_tree.view.ConsoleUI;

import java.util.Scanner;

public abstract class HumanData {
    String description;
    ConsoleUI console;
    Scanner scanner;
    public HumanData(ConsoleUI console) {
        this.console = console;
        this.scanner = new Scanner(System.in);
    }
    public String getDescription() {
        return description;
    }
    public abstract void execute();

}
