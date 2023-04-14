package ui.commands;

import ui.ConsoleUI;

public class QuitMenu extends Command{
    public QuitMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выход из подменю";
    }

    @Override
    public boolean execute() {
        return false;
    }
}
