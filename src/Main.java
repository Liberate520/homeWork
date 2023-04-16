import familyTreeApi.Service;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        Service service = new Service();
        new Presenter(view, service);

        view.start();
    }
}