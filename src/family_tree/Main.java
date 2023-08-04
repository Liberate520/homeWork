package family_tree;

import family_tree.view.ConsoleUI;
import family_tree.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
