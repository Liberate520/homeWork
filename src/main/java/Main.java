import notes.Notes;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        Notes notes = new Notes();
        Presenter presenter = new Presenter(view, notes);
        view.selection();
    }
}
