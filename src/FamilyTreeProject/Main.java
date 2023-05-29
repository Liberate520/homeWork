
import Presenter.Presenter;
import model.Service;
import model.fileHandler.FileHandler;
import ui.Console;
import ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new Console();
        FileHandler fileHandler = new FileHandler();
        Service service = new Service(fileHandler);
        Presenter presenter = new Presenter(view, service);

        view.start();

    }
}
