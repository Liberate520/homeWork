package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SetMother extends Command{
    public SetMother(ConsoleUI consoleUI) {
        super("Установить мать", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setMother();
    }
}
