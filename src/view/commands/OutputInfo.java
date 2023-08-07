package view.commands;

import view.ConsoleUI;

public class OutputInfo extends Command{
    public OutputInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список людей";
    }

    @Override
    public void execute() {
        consoleUI.outputInfo();
    }

}
