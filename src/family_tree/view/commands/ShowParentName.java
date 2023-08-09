package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class ShowParentName extends Command{
    public ShowParentName(ConsoleUI console) {
        super("Показать родителей", console);
    }

    public void execute() {
        getConsole().showParentName();
    }
}
