package view.commands;

import view.ConsoleUI;

public class Marry extends Command {

    public Marry(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить супружескую связь между людьми";
    }

    @Override
    public void execute() {
        consoleUI.marry();
    }
}
