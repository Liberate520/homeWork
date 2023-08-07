package view.commands;

import view.ConsoleUI;

public class Load extends Command{
    public Load(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить из файла";
    }

    @Override
    public void execute() {
        consoleUI.load();
    }
}
