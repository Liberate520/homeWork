package ui.commands.Method;

import ui.ConsoleUI;
import ui.commands.Option;

public class getHumanByName implements Option {
    private ConsoleUI consoleUI;

    public getHumanByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String description() {
        return "Получаем члена семьи";
    }

    @Override
    public void execute() {
        consoleUI.getHumanByName();
    }
    
}
