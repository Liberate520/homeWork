package view.Commands;

import view.ConsoleUI;

public class ReadFile extends Commands{
    ReadFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Прочитать семейное дерево";
    }

    @Override
    public void execute() {
        consoleUI.fileRead();
    }
}
