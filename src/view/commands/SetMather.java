package view.commands;

import view.ConsoleUI;

public class SetMather extends Command{
    public SetMather(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить информацию о матери.";
    }

    @Override
    public void execute() {
        consoleUI.setMather();

    }
}
