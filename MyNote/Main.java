package MyNote;

import javax.swing.text.View;

import MyNote.Model.Model;
import MyNote.UI.ConsoleView;


public class Main {
    public static void main(String[] args) {
        Model model = new Model("notes.txt");
        ConsoleView consoleView = new ConsoleView();
        Presenter presenter = new Presenter(model, consoleView);
        Menu menu = new Menu(presenter,consoleView);
        menu.run();
}
}