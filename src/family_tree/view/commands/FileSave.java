package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class FileSave extends Command{
    public FileSave(ConsoleUI consoleUi) {
        super(consoleUi, "Сохранить.");
    }

    @Override
    public void execute() {
        super.consoleUi.fileSave();
    }
}
