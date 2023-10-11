package View.Commands;

import View.ConsoleUI;

public class AddHumanParent extends Command{
    public AddHumanParent(ConsoleUI consoleUI){
        super("Добавить родителя ребенку (+наоборот)",consoleUI);
    }
    public void execute() {
        getConsoleUI().enterAndAddParent();
    }
}
