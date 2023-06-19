import view.ConsoleUI;
import view.View;

import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
