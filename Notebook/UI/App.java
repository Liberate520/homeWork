package Notebook.UI;

import Notebook.Confing;
import Notebook.Core.MVP.Presenter;
import Notebook.Core.MVP.Views.ViewMenu;
import Notebook.Core.MVP.Views.ViewRecord;

public class App {
    Presenter presenter;
    ViewRecord view;
    ViewMenu num;

    public App() {
        num = new ConsoleMenu();
        view = new ConsoleRecord();
        presenter = new Presenter(view, Confing.pathDb);
    }

    public void start() {
        boolean continueLoop = true;
        presenter.loadFromFile();
        while (continueLoop) {
            Menu menu = new Menu();
            menu.printMenu();
            switch (num.getNum()) {
                case 1:
                    presenter.append();
                    break;
                case 2:
                    presenter.show();
                    break;
                case 3:
                    presenter.set(num.getIndex() - 1);
                    break;
                case 4:
                    presenter.remove(num.getIndex() - 1);
                    break;
                case 5:
                    presenter.save();
                    break;

                case 6:
                    continueLoop = false;
                default:
                    break;
            }
        }
    }

}
