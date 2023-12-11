package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SetFather extends Command {
    public SetFather(ConsoleUI consoleUI) {
        super("Установить отца", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setFather();

    }
}
