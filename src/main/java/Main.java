import notes.DataIO;
import notes.FileIO;
import notes.Notes;
import presenter.Presenter;
import ui.DesktopUI;
import ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new DesktopUI();
        Notes notes = new Notes();
        DataIO dataIO = new FileIO();
        Presenter presenter = new Presenter(view, notes, dataIO);
        view.selection();
    }
}
