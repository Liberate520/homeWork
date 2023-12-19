package view.commands;

import view.ConsoleUI;

public class GetFamily extends Command{
    public GetFamily(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Состав семьи человека.";
    }

    @Override
    public void execute() {
        consoleUI.getFamily();
    }
}
