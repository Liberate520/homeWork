package ui.commands.Method;

import ui.ConsoleUI;
import ui.commands.Option;

public class add implements Option {
    private ConsoleUI consoleUI;

    public add(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String description() {
        return "добавляем нового члена семьи";
    }

    @Override
    public void execute() {
        consoleUI.add();
    }    
}
