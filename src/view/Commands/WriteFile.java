package view.Commands;

import view.ConsoleUI;

public class WriteFile extends Commands{
    WriteFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Записать семейное дерево";
    }

    @Override
    public void execute() {
        consoleUI.fileWriter();
    }
}
