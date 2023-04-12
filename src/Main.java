import model.Service;
import presenter.Presenter;
import view.ConsoleUI;

public class Main {
    static String file_name = "bd.csv";

    public static void main(String[] args) {
        Service service = new Service(file_name,"csv");
        ConsoleUI console = new ConsoleUI();
        new Presenter(service, console);

        console.start();
    }
}
