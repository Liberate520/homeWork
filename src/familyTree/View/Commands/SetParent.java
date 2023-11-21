package familyTree.View.Commands;

import familyTree.View.ConsoleUI;

public class SetParent extends Command {

    public SetParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить родителя";
    }

    @Override
    public void execute() {
        consoleUI.setParent();
    }
}
