package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public class Finish extends Command {

    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String getDescription() {
        return "Закончить работу";
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }

}
