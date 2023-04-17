package ui.commands.Method;

import ui.ConsoleUI;
import ui.commands.Option;

public class sortByBirthDate implements Option {
    private ConsoleUI consoleUI;

    public sortByBirthDate(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String description() {
        return "Сортировка по возрасту";
    }

    @Override
    public void execute() {
        consoleUI.sortByBirthDate();
    }
    
}
