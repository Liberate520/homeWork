package faminly_tree.view.add_human;


import faminly_tree.view.ConsoleUI;
import java.util.Scanner;

public abstract class HumanData {
    String description;
    ConsoleUI console;
    Scanner scanner;
    Container container;
    public HumanData(ConsoleUI console, Container container) {
        this.console = console;
        this.scanner = new Scanner(System.in);
        this.container = container;
    }
    public String getDescription() {
        return description;
    }
    public abstract void execute();
}
