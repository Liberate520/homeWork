package family_tree.view.commands;

import family_tree.view.view.ConsoleUI;

public class FindHumanByID extends Command{
    public FindHumanByID(ConsoleUI console) {
        super("Найти человека по ID", console);
    }

    public void execute() {
        getConsole().findHumanByID();
    }
}
