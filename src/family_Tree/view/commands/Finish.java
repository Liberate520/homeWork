package family_Tree.view.commands;

import family_Tree.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завершить работу";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}
