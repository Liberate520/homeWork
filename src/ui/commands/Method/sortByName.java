package ui.commands.Method;

import ui.ConsoleUI;
import ui.commands.Option;

public class sortByName implements Option {
    private ConsoleUI consoleUI;

    public sortByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String description() {
        return "Сортрирую по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
    
}
