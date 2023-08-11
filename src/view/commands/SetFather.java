package view.commands;

import view.ConsoleUI;

public class SetFather extends Command{
    public SetFather(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить информацию об отце.";
    }

    @Override
    public void execute() {
        consoleUI.setFather();
    }
}
