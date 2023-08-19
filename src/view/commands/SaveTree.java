package view.commands;

import view.ConsoleUI;

public class SaveTree extends Command{

    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить древо", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().saveTree();
    }
}
