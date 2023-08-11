package view.commands;

import view.ConsoleUI;

public class SaveTree extends Command{
    public SaveTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить древо.";
    }

    @Override
    public void execute() {
        consoleUI.saveTree();
    }
}
