package ui.commands.Method;

import ui.commands.Option;
import ui.ConsoleUI;

public class ReadFile implements Option {
    ConsoleUI consoleUI;

    public ReadFile(ConsoleUI consoleUI) {

    }

    @Override
    public String description() {
        return "Считывает дерево из файла";
    }

    @Override
    public void execute() {
        consoleUI.readFile();
    }
    
}
