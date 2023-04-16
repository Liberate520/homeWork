package ui.commands;

import ui.ConsoleUI;

public class PrintMember extends Command {

    public PrintMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести на экран информацию по члену семьи";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().printMember();
    }
}
