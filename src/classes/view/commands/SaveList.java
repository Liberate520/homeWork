package classes.view.commands;

import classes.view.ConsoleUI;

public class SaveList extends Command {
    public SaveList(ConsoleUI consoleUI) {
        super(consoleUI);
        String description = "Записать в файл";
    }

    public void execute() {
        consoleUI.Savelist();
    }
}
