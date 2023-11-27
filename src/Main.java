
import my_family_tree.model.service.Service;
import my_family_tree.view.ConsoleUI;
import my_family_tree.view.View;


public class Main {
    public static void main(String[] args) {

        Service service = new Service();

        View view = new ConsoleUI();
        view.start();

    }
}
