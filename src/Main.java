import Interface.Service;
import Interface.ServiceTree;
import Presenter.Presenter;
import ui.ConsoleUI;
import ui.View;


public class Main {

    public static void main (String[] args) {

        View view = new ConsoleUI();
        Service service = new ServiceTree();
        Presenter presenter = new Presenter(view, service);

        view.start(presenter);

    }
}
