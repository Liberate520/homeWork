package ui.commands.Method;
import java.io.IOException;

import ui.ConsoleUI;
import ui.commands.Option;

public class SaveFile implements Option {
    private ConsoleUI consoleUI;

    public SaveFile(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String description() {
        return "Сохраняем дерево в файл";
    }

    @Override
    public void execute() {
        try {
            consoleUI.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
