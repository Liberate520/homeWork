package family_Tree.view.commands;

import family_Tree.view.ConsoleUI;

public class Save extends Command{
    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить изменения";
    }

    @Override
    public void execute() {
        consoleUI.save();
    }
}
