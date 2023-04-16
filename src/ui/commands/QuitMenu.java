package ui.commands;

import ui.ConsoleUI;

public class QuitMenu extends Command{
    public QuitMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выход из подменю редактирования древа";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().quitMenu();
    }
}
