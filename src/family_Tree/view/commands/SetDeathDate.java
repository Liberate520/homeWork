package family_Tree.view.commands;

import family_Tree.view.ConsoleUI;

public class SetDeathDate extends Command{
    public SetDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить дату смерти";
    }

    @Override
    public void execute() {
        consoleUI.setDeathDate();
    }
}
