
import my_family_tree.model.service.Service;
import my_family_tree.model.writer.FileHandler;
import my_family_tree.view.ConsoleUI;
import my_family_tree.view.View;


public class Main {
    public static void main(String[] args) {

        Service service = new Service();

        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.setWritable(new FileHandler());
        consoleUI.start();

    }
}
