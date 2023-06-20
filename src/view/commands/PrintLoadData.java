package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class PrintLoadData implements Command {
    private ConsoleUI consoleUI;

    public PrintLoadData(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Загрузить данные из файла";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.printLoadData();
    }
}