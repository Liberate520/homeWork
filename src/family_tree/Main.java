package family_tree;

import family_tree.view.ConsoleUI;
import family_tree.view.View;
import java.time.LocalDate;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }

    public class CLS {
        public static void main(String... arg) throws IOException, InterruptedException {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
}