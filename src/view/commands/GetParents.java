package view.commands;

import view.ConsoleUI;

public class GetParents extends Command{

    public GetParents(ConsoleUI consoleUI) {
        super("Показать родителей", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().getParents();
    }
}
