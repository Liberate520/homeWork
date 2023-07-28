package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class ShowSiblings extends Command{
    public ShowSiblings(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать братьев и сестер";
    }

    @Override
    public void execute() {
        consoleUI.showSiblings();
    }
}
