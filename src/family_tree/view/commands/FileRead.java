package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class FileRead extends Command{
    public FileRead(ConsoleUI consoleUi) {
        super(consoleUi, "Загрузить.");
    }

    @Override
    public void execute() {
        super.consoleUi.fileRead();
    }
}
