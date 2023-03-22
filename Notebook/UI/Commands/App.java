package Notebook.UI.Commands;

import Notebook.Confing;
import Notebook.Core.MVP.Presenter;
import Notebook.Core.MVP.Views.ViewMenu;
import Notebook.Core.MVP.Views.ViewRecord;
import Notebook.UI.ConsoleMenu;
import Notebook.UI.ConsoleRecord;
import Notebook.UI.Menu;

public class App {
    Presenter presenter;
    ViewRecord view;
    ViewMenu num;
    Command[] options;

    public App() {
        num = new ConsoleMenu();
        view = new ConsoleRecord();
        presenter = new Presenter(view, Confing.pathDb);
        options = new Command[] {
            new AddRecordingCommand(presenter),
            new ShowAllCommand(presenter),
            new EditRecordingCommand(presenter, num),
            new DeleteRecordingCommand(presenter, num),
            new SaveChangesCommand(presenter),
            new ExitCommand()
            };
    }

    public void start() {
        boolean continueLoop = true;
        presenter.loadFromFile();
        while (continueLoop) {
            Menu menu = new Menu();
            menu.printMenu();
            int optionNum = num.getNum() - 1;
            if (optionNum >= 0 && optionNum < options.length) {
                options[optionNum].execute();
                if (options[optionNum] instanceof ExitCommand) {
                    continueLoop = false;
                }
            }
        }
    }

}
