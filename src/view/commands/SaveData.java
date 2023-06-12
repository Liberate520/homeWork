package view.commands;

import view.Command;
import view.ConsoleUI;

import java.io.IOException;

public class SaveData implements Command {
    private ConsoleUI consoleUI;

    public SaveData(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Сохранить данные в файл";
    }

    @Override
    public void execute() throws IOException {
        consoleUI.saveData();
    }
}