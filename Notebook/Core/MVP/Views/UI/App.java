package notebook.core.mvp.views.UI;

import notebook.core.mvp.Presenter;
import notebook.core.mvp.views.ViewRecord;
import notebook.db.Confing;

public class App {
    Presenter presenter;
    ViewRecord view;
    Menu menu;

    public App() {
        view = new ConsoleRecord();
        presenter = new Presenter(view, Confing.pathDb);
        menu = new Menu(presenter);
    }

    public void start() {
        boolean continueLoop = true;
        presenter.loadFromFile();
        while (continueLoop) {
            menu.printMenu();
            int optionNum = menu.getPunktMenu() - 1;
            if (optionNum >= 0 && optionNum < menu.options.length) {
                menu.options[optionNum].execute();
            }
        }
    }
}
