package Homework.view.commands;

import Homework.view.ConsoleUI;

public class ReadFile extends Command {
    public ReadFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Прочитать из файла";
    }

    public void execute() {
        consoleUI.readFile();
    }
}
