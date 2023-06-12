package view.commands;

import view.Command;
import view.ConsoleUI;

import java.io.IOException;

public class LoadData implements Command {
    private ConsoleUI consoleUI;

    public LoadData(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Загрузить данные из файла";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.loadData();
    }
}