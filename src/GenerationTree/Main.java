package GenerationTree;

import GenerationTree.View.View;
import GenerationTree.View.ConsoleUI.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.startup();
    }
}