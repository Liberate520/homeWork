import model.Service;
import presenter.Presenter;
import view.ConsoleUI;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // Service service = new Service("bd.csv","csv");
        Service service = new Service("bd.bin", "binary");
        ConsoleUI console = new ConsoleUI();
        new Presenter(service, console);

        console.start();
    }
}
