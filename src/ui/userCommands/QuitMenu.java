package ui.userCommands;

import ui.ConsoleUI;

public class QuitMenu extends Command{
    public QuitMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Покинуть ветку меню";
    }

    @Override
    public boolean execute() {
        return false;
    }
}
