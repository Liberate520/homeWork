package family_Tree;

import family_Tree.model.writer.FileHandler;
import family_Tree.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.setWritable(new FileHandler());
        consoleUI.start();
    }
}