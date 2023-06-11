package view.menu.commands;

import view.ConsoleUI;

public class FileImportCheck implements Command {
    private ConsoleUI consoleUI;

    public FileImportCheck(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return consoleUI.treeFileImportCheckView();
    }

    @Override
    public void execute() {
        consoleUI.importFile();

    }
}
