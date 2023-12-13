package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Finish extends Command{


    public Finish(ConsoleUI consoleUI) {
        super("Закончить работу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}

