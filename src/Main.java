import presenter.Presenter;
import treeAPI.Service;
import ui.ConsoleUI;
import ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        Service service = new Service();
        Presenter presenter = new Presenter(view, service);

        view.start();
    }
}