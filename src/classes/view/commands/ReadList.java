package classes.view.commands;

import classes.view.ConsoleUI;

public class ReadList extends Command {
    public ReadList(ConsoleUI consoleUI) {
        super(consoleUI);
        String description = "Прочитать из файла";
    }

    public void execute() {
        consoleUI.ReadList();
    }
}
