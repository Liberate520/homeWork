package ui.commands.Method;

import ui.ConsoleUI;
import ui.commands.Option;

public class deleteByName implements Option {
    private ConsoleUI consoleUI;

    public deleteByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String description() {
        return "Удаляем члена семьи из дерева";
    }

    @Override
    public void execute() {
        consoleUI.deleteByName();
    }
    
}
