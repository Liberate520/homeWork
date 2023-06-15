package tree.view.commands;

import tree.view.ConsoleUI;

public class Finish implements Command{
    private ConsoleUI consoleUI;

    public Finish(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Завершение работы";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}
