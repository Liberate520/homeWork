package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SiblingName extends Command{
    public SiblingName(ConsoleUI console) {
        super("Показать сиблингов", console);
    }

    public void execute() {
        getConsole().showSibling();
    }
}
