package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SetWedding extends Command{
    public SetWedding(ConsoleUI consoleUI) {
        super("Соединить в семейную пару", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setWedding();
    }
}
