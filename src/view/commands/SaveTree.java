package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class SaveTree implements Command {
    private ConsoleUI consoleUI;

    public SaveTree(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Сохранить фамильное дерево";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.saveTree();
    }
}
