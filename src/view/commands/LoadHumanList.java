package view.commands;

import view.ConsoleUI;

public class LoadHumanList extends Command{
    public LoadHumanList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить список людей.";
    }

    @Override
    public void execute() {
        consoleUI.loadHumanList();
    }
}
