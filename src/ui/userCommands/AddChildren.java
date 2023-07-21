package ui.userCommands;
import ui.ConsoleUI;

public class AddChildren extends Command{
    public AddChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().addChild();
    }
}
