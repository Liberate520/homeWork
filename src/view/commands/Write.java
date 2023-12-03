package view.commands;

import view.ConsoleUI;

public class Write extends Command {
    public Write(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить в файл";
    }

    public void execute(){
        consoleUI.write();
    }
}
