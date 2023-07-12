package family_tree;
import family_tree.infrastucture.My_Scanner;
import family_tree.view.Menu;
import java.util.Scanner;

public class Main implements My_Scanner {
    Scanner sc = My_Scanner.sc;

    public static void main(String[] args) {
        Main main = new Main();
        Menu menu = new Menu();
        System.out.println("СЕМЕЙНОЕ ДРЕВО.");
        menu.startMenu();
        main.sc.close();
        System.out.println("СЕМЕЙНОЕ ДРЕВО. Программа закрыта.");
    }


}
