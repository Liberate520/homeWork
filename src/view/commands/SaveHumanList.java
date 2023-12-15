package view.commands;

import view.ConsoleUI;

public class SaveHumanList extends Command{
    public SaveHumanList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить список людей.";
    }

    @Override
    public void execute() {
        consoleUI.saveHumanList();
    }
}
