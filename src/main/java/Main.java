import notes.Service;
import notes.data.Notes;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        Service service = new Notes();
        Presenter presenter = new Presenter(view, service);
        presenter.start();
    }
}
