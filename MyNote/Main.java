package MyNote;

import MyNote.UI.ConsoleView;
import MyNote.UI.Menu;

public class Main {
    public static void main(String[] args) {
            String note = "notes.txt";
            Model model = new Model(note);
            ConsoleView consoleView = new ConsoleView();
            Presenter presenter = new Presenter(model, consoleView);
            Menu console = new Menu(presenter,consoleView);
            console.start();
    }
}
