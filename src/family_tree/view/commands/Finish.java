package family_tree.view.commands;

import family_tree.view.view.ConsoleUI;

public class Finish  extends Command{
    public Finish(ConsoleUI consoleUI) {
        super("Завершить работу", consoleUI);
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
