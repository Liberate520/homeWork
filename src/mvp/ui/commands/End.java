package mvp.ui.commands;

import mvp.ui.ConsoleUI;

public class End implements Command{
    
    private ConsoleUI consoleUI;

    public End(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Выйти из приложения";
    }

    @Override
    public void execute() {
        consoleUI.end();
    }
}
