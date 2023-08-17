package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Remove extends Command{
    public Remove(ConsoleUI consoleUi) {
        super(consoleUi, "Убрать человека.");
    }

    @Override
    public void execute() {
        super.consoleUi.remove();
    }
}
