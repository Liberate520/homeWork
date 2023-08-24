package View.commands;

import View.ConsoleUI;

public class SaveTreeToFile extends Command{
    public SaveTreeToFile(ConsoleUI consoleUI) {
        super("Сохранить дерево в файл в папке Data", consoleUI);
    }

    @Override
    public void execute() {
        super.consoleUI.saveToFile();
    }
}
