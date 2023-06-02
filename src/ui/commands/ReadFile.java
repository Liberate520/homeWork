package ui.commands;

import ui.Console;

public class ReadFile implements Command {
    private Console console;

    public ReadFile(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Распечатать дерево из файла";
    }

    @Override
    public void execute() {
        console.readFile();
    }
}
