package homeWork.view.Commands;

import homeWork.view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Дело сделано!";
    }

    public void execute() {
        consoleUI.finish();
    }
}
