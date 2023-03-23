package Notebook.UI.Commands;

import Notebook.Core.MVP.Presenter;
import Notebook.Core.MVP.Views.ViewMenu;
import Notebook.Core.MVP.Views.ViewRecord;
import Notebook.DB.Confing;
import Notebook.UI.ConsoleMenu;
import Notebook.UI.ConsoleRecord;


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
            int i = 1;
            for (Command command : options) {
                System.out.printf("\t%d. ", i++);
                command.printCommand();
            }
            int optionNum = num.getPunktMenu() - 1;
            if (optionNum >= 0 && optionNum < options.length) {
                options[optionNum].execute();
                if (options[optionNum] instanceof ExitCommand) {
                    continueLoop = false;
                }
            }
        }
    }

}
