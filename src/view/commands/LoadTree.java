package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class LoadTree implements Command {
    private ConsoleUI consoleUI;

    public LoadTree(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Загрузить фамильное дерево";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.loadTree();
    }
}
