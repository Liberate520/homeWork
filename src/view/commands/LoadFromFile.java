package view.commands;

import view.ConsoleUI;

public class LoadFromFile extends Command {
    public LoadFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить дерево из файла";
    }
    @Override
    public void execute() {
        consoleUI.loadFromFile();
    }
}
