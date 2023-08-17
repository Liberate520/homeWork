package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public class Load extends Command {
    public Load(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String getDescription() {
        return "Загрузить семью";
    }

    @Override
    public void execute() {
        getConsoleUI().loadFamily();
    }
}
