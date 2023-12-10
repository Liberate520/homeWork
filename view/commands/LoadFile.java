
package view.commands;

import view.ConsoleUI;

public class LoadFile extends Command {
    public LoadFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить из файла";
    }

    public void execute() {
        consoleUI.loadFile();
    }

}
