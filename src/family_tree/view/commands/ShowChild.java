package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class ShowChild extends Command{
    public ShowChild(ConsoleUI console) {
        super("Показать детей", console);
    }

    public void execute() {
        getConsole().showChildName();
    }
}
