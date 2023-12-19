package view.commands;

import view.ConsoleUI;

public class HumanDeath extends Command{
    public HumanDeath(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сообщить о смерти человека.";
    }

    @Override
    public void execute() {
        consoleUI.humanDeath();
    }
}
