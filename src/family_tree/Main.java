package family_tree;
import family_tree.view.ConsoleUI;
import family_tree.view.Menu;


public class Main {


    public static void main(String[] args) {
        Menu menu = new Menu();
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
        menu.startMenu();
        consoleUI.finish();
    }

}
