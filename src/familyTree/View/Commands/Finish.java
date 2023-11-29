package familyTree.View.Commands;

import familyTree.View.ConsoleUI;

public class Finish extends Command {

    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завершить работу";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}

