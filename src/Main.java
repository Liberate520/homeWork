

import view.ConsoleUI;
import model.writer.FileHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleUI console = new ConsoleUI();
        console.setWritable(new FileHandler());
        console.start();
    }
}
