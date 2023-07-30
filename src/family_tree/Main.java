package family_tree;

import family_tree.view.ConsoleUi;
import family_tree.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUi();
        view.start();
    }

}
