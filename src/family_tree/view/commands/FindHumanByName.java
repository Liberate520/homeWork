package family_tree.view.commands;

import family_tree.view.view.ConsoleUI;

public class FindHumanByName extends Command{
    public FindHumanByName(ConsoleUI console) {
        super("Найти человека по имени", console);
    }

    public void execute() {
        getConsole().findHumanByName();
    }
}
