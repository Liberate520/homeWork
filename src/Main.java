import GenerationTree.interfaces.View;
import GenerationTree.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}