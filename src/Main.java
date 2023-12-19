
import model.writer.FileHandler;
import view.ConsoleUI;


public class Main {

    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.setWritable(new FileHandler());
        consoleUI.start();

    }
}

